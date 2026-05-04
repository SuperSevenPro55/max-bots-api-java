package ru.max.bots.api.objects.message.body.attachments.buttons;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RequestContactButton(
        @JsonProperty("text")
        String text
) implements Button {}
