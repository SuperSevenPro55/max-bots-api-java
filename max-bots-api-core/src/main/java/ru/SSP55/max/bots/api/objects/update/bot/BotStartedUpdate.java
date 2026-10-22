package ru.SSP55.max.bots.api.objects.update.bot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BotStartedUpdate extends BotUpdate {
    @JsonProperty("payload")
    private String payload;

    @JsonProperty("user_locale")
    private String userLocale;
}