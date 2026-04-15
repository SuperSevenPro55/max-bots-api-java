package ru.max.bots.api.objects.message.helpers.body.markup;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Простая разметка.
 * @param type тип элемента разметки
 * @param from индекс начала разметки в тексте. Нумерация с нуля.
 * @param length длина элемента разметки
 * @author SuperSevenPro55
 * @version 0.2
 */

public record SimpleMarkupElement(
    @JsonProperty("type")
    String type,

    @JsonProperty("from")
    Integer from,

    @JsonProperty("length")
    Integer length
) implements MarkupElement {}
