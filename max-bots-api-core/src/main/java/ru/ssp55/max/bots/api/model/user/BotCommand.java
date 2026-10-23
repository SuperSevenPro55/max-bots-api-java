package ru.ssp55.max.bots.api.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.ssp55.max.bots.api.model.MaxApiObject;

/**
 * Команда, поддерживаемая ботом
 * @author SuperSevenPro55
 * @version 0.1
 * @param name Название команды (от 1 до 64 символов).
 * @param description Описание команды (от 1 до 128 символов). Опционально.
 */

public record BotCommand(
        @JsonProperty("name")
        String name,

        @JsonProperty("description")
        String description
) implements MaxApiObject {}
