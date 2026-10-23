package ru.ssp55.max.bots.api.spring.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "max.bot")
public class MaxBotProperties {
    private String token;
    private String baseUrl = "https://platform-api.max.ru";
}
