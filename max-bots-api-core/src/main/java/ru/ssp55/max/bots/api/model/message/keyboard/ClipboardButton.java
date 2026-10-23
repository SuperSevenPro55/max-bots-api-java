package ru.ssp55.max.bots.api.model.message.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClipboardButton(
        @JsonProperty("text")
        String text,

        @JsonProperty("payload")
        String payload
) implements Button {}
