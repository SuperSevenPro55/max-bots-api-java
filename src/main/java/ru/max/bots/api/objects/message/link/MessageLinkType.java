package ru.max.bots.api.objects.message.link;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Тип связанного сообщения
 * @author SuperSevenPro55
 * @version 0.2
 */

public enum MessageLinkType {
    @JsonProperty("forward")
    FORWARD,

    @JsonProperty("reply")
    REPLY
}
