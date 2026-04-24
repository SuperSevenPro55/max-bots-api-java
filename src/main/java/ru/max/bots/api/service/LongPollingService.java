package ru.max.bots.api.service;

import ru.max.bots.api.client.MaxClient;
import ru.max.bots.api.methods.get.GetUpdates;
import ru.max.bots.api.methods.get.GetUpdatesResponse;
import ru.max.bots.api.objects.Update;

import java.util.function.Consumer;

public class LongPollingService {
    private final MaxClient maxClient;
    private long lastUpdateId = 0;
    private volatile boolean isRunning = false;

    public LongPollingService(MaxClient maxClient) {
        this.maxClient = maxClient;
    }

    /**
     * Запускает бесконечный цикл получения обновлений
     *
     * @param updateHandler код, который будет выполняться для каждого нового Update
     */
    public void start(Consumer<Update> updateHandler) {
        isRunning = true;
        System.out.println("Long Polling успешно запущен. Ожидание событий...");

        while (isRunning) {
            try {
                // Передаем lastUpdateId как offset (без +1, так как MAX сам дает точный marker)
                GetUpdates getUpdatesRequest = GetUpdates.builder()
                        .offset(lastUpdateId == 0 ? null : lastUpdateId)
                        .timeout(30)
                        .build();

                // Теперь мы получаем GetUpdatesResponse!
                GetUpdatesResponse response = maxClient.execute(getUpdatesRequest);

                // Если пришел ответ и там есть обновления
                if (response != null && response.getUpdates() != null) {
                    for (Update update : response.getUpdates()) {
                        updateHandler.accept(update);
                    }

                    // Сохраняем marker на будущее!
                    if (response.getMarker() != null) {
                        lastUpdateId = response.getMarker();
                    }
                }
            } catch (Exception e) {
                System.err.println("Ошибка при получении обновлений (Long Polling): " + e.getMessage());
                e.printStackTrace();
                // В случае разрыва соединения ждем 2 секунды перед новой попыткой, чтобы не спамить сервер
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void stop() {
        isRunning = false;
        System.out.println("Long Polling остановлен.");
    }
}