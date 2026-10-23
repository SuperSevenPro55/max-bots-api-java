package ru.ssp55.max.bots.api.model.message;

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
