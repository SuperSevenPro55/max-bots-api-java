package ru.max.bots.api.objects.update.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.max.bots.api.objects.user.User;

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
