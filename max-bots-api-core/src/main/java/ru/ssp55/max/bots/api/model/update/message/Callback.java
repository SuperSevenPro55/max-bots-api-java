package ru.ssp55.max.bots.api.model.update.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.ssp55.max.bots.api.model.user.User;

public record Callback(
        @JsonProperty("timestamp")
        Long timestamp,

        @JsonProperty("callback_id")
        String callbackId,

        @JsonProperty("payload")
        String payload,

        @JsonProperty("user")
        User user
) {}
