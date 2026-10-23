package ru.ssp55.max.bots.api.model.message.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OpenAppButton(
        @JsonProperty("text")
        String text,

        @JsonProperty("web_app")
        String webApp,

        @JsonProperty("contact_id")
        Long contactId,

        @JsonProperty("payload")
        String payload
) implements Button {}
