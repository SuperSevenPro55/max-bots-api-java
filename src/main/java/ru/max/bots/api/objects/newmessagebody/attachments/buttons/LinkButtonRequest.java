package ru.max.bots.api.objects.newmessagebody.attachments.buttons;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LinkButtonRequest(
        @JsonProperty("text")
        String text,

        @JsonProperty("url")
        String url
) implements ButtonRequest {}
