package ru.ssp55.max.bots.api.model.chat;

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
