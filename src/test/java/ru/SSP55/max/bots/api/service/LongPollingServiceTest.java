package ru.SSP55.max.bots.api.service;

import org.junit.jupiter.api.Test;
import ru.SSP55.max.bots.api.client.MaxClient;
import ru.SSP55.max.bots.api.core.MaxBotUpdateListener;
import ru.SSP55.max.bots.api.objects.update.message.MessageCallbackUpdate;
import ru.SSP55.max.bots.api.objects.update.message.MessageCreatedUpdate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LongPollingServiceTest {
    @Test
    void testLongPollingWithDispatcher() throws InterruptedException {
        String token = System.getenv("BOT_MAX_TOKEN");
        MaxClient client = new MaxClient(token, "https://platform-api.max.ru/");

        CountDownLatch latch = new CountDownLatch(1);

        MaxBotUpdateListener listener = new MaxBotUpdateListener() {
            @Override
            public void onMessageCreated(MessageCreatedUpdate update) {
                String text = update.getMessage().getBody().text();
                System.out.println("Получено сообщение: " + text);

                if ("стоп".equalsIgnoreCase(text)) {
                    System.out.println("Стоп-слово получено. Завершаем работу...");
                    latch.countDown();
                }
            }

            @Override
            public void onMessageCallback(MessageCallbackUpdate update) {
                var cb = update.getCallback();
                System.out.println("Нажата кнопка!");
                System.out.println("ID кнопки: " + cb.callbackId());
                System.out.println("Payload: " + cb.payload());
                System.out.println("Пользователь: " + cb.user().getFirstName());
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Ошибка: " + throwable.getMessage());
            }
        };

        LongPollingService service = new LongPollingService(client);
        service.start(listener);

        System.out.println("Бот запущен. Отправь ему сообщение 'стоп', чтобы остановить тест.");

        boolean completed = latch.await(10, TimeUnit.MINUTES);

        service.stop();

        if (!completed) {
            System.out.println("Тест завершен по таймауту.");
        } else {
            System.out.println("Тест успешно завершен.");
        }
    }
}
