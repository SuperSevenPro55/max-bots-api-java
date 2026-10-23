package ru.ssp55.max.bots.api.service;

import ru.ssp55.max.bots.api.client.MaxClient;
import ru.ssp55.max.bots.api.dispatcher.MaxBotUpdateDispatcher;
import ru.ssp55.max.bots.api.dispatcher.MaxBotUpdateListener;
import ru.ssp55.max.bots.api.method.subscription.longpolling.GetUpdates;
import ru.ssp55.max.bots.api.method.subscription.longpolling.GetUpdatesResponse;
import ru.ssp55.max.bots.api.model.update.Update;

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