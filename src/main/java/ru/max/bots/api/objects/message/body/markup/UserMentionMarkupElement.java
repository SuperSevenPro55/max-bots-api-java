package ru.max.bots.api.objects.message.body.markup;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Разметка упомянутый пользователь
 * @param type тип элемента разметки
 * @param from индекс начала разметки в тексте. Нумерация с нуля.
 * @param length длина элемента разметки
 * @param userLink @username упомянутого пользователя
 * @param userId ID упомянутого пользователя без имени
 * @author SuperSevenPro55
 * @version 0.2
 */

public record UserMentionMarkupElement(
        @JsonProperty("type")
        String type,

        @JsonProperty("from")
        Integer from,

        @JsonProperty("length")
        Integer length,

        @JsonProperty("user_link")
        String userLink,

        @JsonProperty("user_id")
        Long userId
) implements MarkupElement {}
