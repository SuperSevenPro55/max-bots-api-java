package ru.max.bots.api.objects.newmessagebody.attachments.buttons;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OpenAppButtonRequest(
        @JsonProperty("text")
        String text,

        @JsonProperty("web_app")
        String webApp,

        @JsonProperty("contact_id")
        Long contactId,

        @JsonProperty("payload")
        String payload
) implements ButtonRequest {}
