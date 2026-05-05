package ru.max.bots.api.objects.newmessagebody.attachments.buttons;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RequestContactButtonRequest(
        @JsonProperty("text")
        String text
) implements ButtonRequest {}
