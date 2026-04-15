package ru.max.bots.api.objects.message.helpers.body.markup;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Разметка-ссылка
 * @param type тип элемента разметки
 * @param from индекс начала разметки в тексте. Нумерация с нуля.
 * @param length длина элемента разметки
 * @param url URL ссылки. От 1 до 2048 символов.
 * @author SuperSevenPro55
 * @version 0.2
 */

public record LinkMarkupElement(
        @JsonProperty("type")
        String type,

        @JsonProperty("from")
        Integer from,

        @JsonProperty("length")
        Integer length,

        @JsonProperty("url")
        String url
) implements MarkupElement {}
