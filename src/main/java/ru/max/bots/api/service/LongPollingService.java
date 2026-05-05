package ru.max.bots.api.service;

import ru.max.bots.api.client.MaxClient;
import ru.max.bots.api.core.MaxBotUpdateDispatcher;
import ru.max.bots.api.core.MaxBotUpdateListener;
import ru.max.bots.api.methods.get.GetUpdates;
import ru.max.bots.api.methods.get.GetUpdatesResponse;
import ru.max.bots.api.objects.update.Update;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LongPollingService {
    private long lastUpdateId = 0;
    private volatile boolean isRunning = false;

    private final MaxClient maxClient;
    private ExecutorService executorService;

    public LongPollingService(MaxClient maxClient) {
        this.maxClient = maxClient;
    }

    public void start(MaxBotUpdateListener listener) {
        if (isRunning) return;
        isRunning = true;


        MaxBotUpdateDispatcher dispatcher = new MaxBotUpdateDispatcher(listener);

        executorService = Executors.newSingleThreadExecutor();

        executorService.submit(() -> {
            while (isRunning) {
                try {
                    GetUpdates getUpdatesRequest = GetUpdates.builder()
                            .offset(lastUpdateId == 0 ? null : lastUpdateId)
                            .timeout(30)
                            .build();

                    GetUpdatesResponse response = maxClient.execute(getUpdatesRequest);

                    if (response != null && response.getUpdates() != null) {
                        for (Update update : response.getUpdates()) {
                            dispatcher.dispatch(update);
                        }

                        if (response.getMarker() != null) {
                            lastUpdateId = response.getMarker();
                        }
                    }
                } catch (Exception e) {
                    listener.onError(e);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
    }

    public void stop() {
        isRunning = false;
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}