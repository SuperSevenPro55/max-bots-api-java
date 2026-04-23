package ru.max.bots.api.objects.message.recipient;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Тип чата
 * @author SuperSevenPro55
 * @version 0.2
 */

public enum ChatType {
    @JsonProperty("chat")
    CHAT,

    @JsonProperty("dialog")
    DIALOG
}
