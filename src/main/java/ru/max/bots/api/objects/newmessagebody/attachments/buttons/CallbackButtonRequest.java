package ru.max.bots.api.objects.newmessagebody.attachments.buttons;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CallbackButtonRequest(
        @JsonProperty("text")
        String text,

        @JsonProperty("payload")
        String payload
) implements ButtonRequest {}
