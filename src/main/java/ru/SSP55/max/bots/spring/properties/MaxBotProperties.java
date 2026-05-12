package ru.SSP55.max.bots.spring.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "max.bot")
public class MaxBotProperties {
    private String token;
    private String baseUrl = "https://platform-api.max.ru";
}
