package ru.SSP55.max.bots.spring.autoconfigure;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.SSP55.max.bots.api.client.MaxClient;
import ru.SSP55.max.bots.api.core.MaxBotUpdateListener;
import ru.SSP55.max.bots.api.service.LongPollingService;
import ru.SSP55.max.bots.spring.properties.MaxBotProperties;

@AutoConfiguration
@ConditionalOnClass(MaxClient.class)
@EnableConfigurationProperties(MaxBotProperties.class)
public class MaxBotAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public MaxClient maxClient(MaxBotProperties properties) {
        if (properties.getToken() == null || properties.getToken().isEmpty()) {
            throw new IllegalStateException("Не указан токен бота. Добавьте max.bot.token");
        }

        return new MaxClient(properties.getToken(), properties.getBaseUrl());
    }

    @Bean
    @ConditionalOnMissingBean
    public LongPollingService longPollingService(MaxClient maxClient) {
        return new LongPollingService(maxClient);
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(MaxBotUpdateListener.class)
    public MaxBotLifecycleManager maxBotLifecycleManager(LongPollingService longPollingService, MaxBotUpdateListener maxBotUpdateListener) {
        return new MaxBotLifecycleManager(longPollingService, maxBotUpdateListener);
    }
}
