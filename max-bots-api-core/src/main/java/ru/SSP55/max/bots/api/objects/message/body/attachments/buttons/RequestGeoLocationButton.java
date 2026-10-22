package ru.SSP55.max.bots.api.objects.message.body.attachments.buttons;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RequestGeoLocationButton(
        @JsonProperty("text")
        String text,

        @JsonProperty("quick")
        Boolean quick
) implements Button {}
