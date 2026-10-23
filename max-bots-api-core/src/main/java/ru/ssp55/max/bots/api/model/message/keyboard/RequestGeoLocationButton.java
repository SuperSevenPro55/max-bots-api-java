package ru.ssp55.max.bots.api.model.message.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RequestGeoLocationButton(
        @JsonProperty("text")
        String text,

        @JsonProperty("quick")
        Boolean quick
) implements Button {}
