package ru.max.bots.api.objects.newmessagebody.link;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.max.bots.api.objects.MaxApiObject;
import ru.max.bots.api.objects.message.link.MessageLinkType;

/**
 * Ссылка на сообщение
 * @param type Тип ссылки сообщения
 * @param mid ID сообщения исходного сообщения
 */

public record NewMessageLink(
        @JsonProperty("type") MessageLinkType type,
        @JsonProperty("mid") String mid
) implements MaxApiObject {}
