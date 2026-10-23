package ru.ssp55.max.bots.api.objects.newmessagebody.attachments.buttons;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RequestGeoLocationButtonRequest(
        @JsonProperty("text")
        String text,

        @JsonProperty("quick")
        Boolean quick
) implements ButtonRequest {}
