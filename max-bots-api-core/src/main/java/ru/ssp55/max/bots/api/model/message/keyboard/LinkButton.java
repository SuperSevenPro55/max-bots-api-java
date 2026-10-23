package ru.ssp55.max.bots.api.model.message.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LinkButton(
        @JsonProperty("text")
        String text,

        @JsonProperty("url")
        String url
) implements Button {}
