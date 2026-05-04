package ru.max.bots.api.objects.message.body.attachments.buttons;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OpenAppButton(
        @JsonProperty("text")
        String text,

        @JsonProperty("web_app")
        String webApp,

        @JsonProperty("contact_id")
        Long contactId,

        @JsonProperty("payload")
        String payload
) implements Button {}
