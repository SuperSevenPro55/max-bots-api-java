package ru.ssp55.max.bots.api.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.ssp55.max.bots.api.model.MaxApiObject;

/**
 * Ссылка на сообщение
 * @param type Тип ссылки сообщения
 * @param mid ID сообщения исходного сообщения
 */

public record NewMessageLink(
        @JsonProperty("type") MessageLinkType type,
        @JsonProperty("mid") String mid
) implements MaxApiObject {}
