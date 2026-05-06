package ru.SSP55.max.bots.api.objects.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.SSP55.max.bots.api.objects.MaxApiObject;

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
