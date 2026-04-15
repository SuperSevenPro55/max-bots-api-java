package ru.max.bots.api.objects.message.helpers.link;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import ru.max.bots.api.interfaces.MaxApiObject;
import ru.max.bots.api.objects.message.helpers.body.MessageBody;
import ru.max.bots.api.objects.user.User;

/**
 * Пересланное или ответное сообщение.
 * @param type Тип связанного сообщения.
 * @param sender Пользователь, отправивший сообщение. Опционально.
 * @param chatId Чат, в котором сообщение было изначально опубликовано. Только для пересланных сообщений. Опционально.
 * @param message Схема, представляющая тело сообщения.
 * @author SuperSevenPro55
 * @version 0.2
 */

public record LinkedMessage(
    @JsonProperty("type")
    @NonNull
    MessageLinkType type,

    @JsonProperty("sender")
    User sender,

    @JsonProperty("chat_id")
    Long chatId,

    @JsonProperty("message")
    @NonNull
    MessageBody message
) implements MaxApiObject {}
