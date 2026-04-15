package ru.max.bots.api.objects.message.helpers.body.markup;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Заглушка для неизвестных типов разметки
 * @author SuperSevenPro55
 * @version 0.2
 * @param type тип элемента разметки
 * @param from индекс начала разметки в тексте. Нумерация с нуля.
 * @param length длина элемента разметки
 */

public record UnknownMarkupElement(
        @JsonProperty("type")
        String type,

        @JsonProperty("from")
        Integer from,

        @JsonProperty("length")
        Integer length
) implements MarkupElement {}
