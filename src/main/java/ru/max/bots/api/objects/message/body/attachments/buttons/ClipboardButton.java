package ru.max.bots.api.objects.message.body.attachments.buttons;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClipboardButton(
        @JsonProperty("text")
        String text,

        @JsonProperty("payload")
        String payload
) implements Button {}
