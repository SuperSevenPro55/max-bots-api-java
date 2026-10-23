package ru.ssp55.max.bots.api.model.message.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageButton(
        @JsonProperty("text")
        String text
) implements Button {}
