package ru.max.bots.api.objects.message.body.attachments.buttons;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LinkButton(
        @JsonProperty("text")
        String text,

        @JsonProperty("url")
        String url
) implements Button {}
