package ru.max.bots.api.objects.newmessagebody.format;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Тип форматирования текста
 * @author SuperSevenPro55
 * @version 0.2
 */

public enum TextFormat {
    @JsonProperty("markdown")
    MARKDOWN,

    @JsonProperty("html")
    HTML
}
