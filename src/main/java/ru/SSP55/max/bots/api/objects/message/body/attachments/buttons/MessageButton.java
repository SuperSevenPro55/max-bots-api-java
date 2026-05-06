package ru.SSP55.max.bots.api.objects.message.body.attachments.buttons;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageButton(
        @JsonProperty("text")
        String text
) implements Button {}
