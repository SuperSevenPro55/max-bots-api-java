package ru.SSP55.max.bots.spring.autoconfigure;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import ru.SSP55.max.bots.api.core.MaxBotUpdateListener;
import ru.SSP55.max.bots.api.service.LongPollingService;

public class MaxBotLifecycleManager {
    private final LongPollingService longPollingService;
    private final MaxBotUpdateListener maxBotUpdateListener;

    public MaxBotLifecycleManager(LongPollingService longPollingService, MaxBotUpdateListener maxBotUpdateListener) {
        this.longPollingService = longPollingService;
        this.maxBotUpdateListener = maxBotUpdateListener;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startBot() {
        longPollingService.start(maxBotUpdateListener);
    }

    @EventListener(ContextClosedEvent.class)
    public void stopBot() {
        longPollingService.stop();
    }
}
