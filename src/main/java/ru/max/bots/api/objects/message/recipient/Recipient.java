package ru.max.bots.api.objects.message.recipient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import ru.max.bots.api.objects.MaxApiObject;

/**
 * Получатель сообщения. Может быть пользователем или чатом
 * @param chatId ID чата
 * @param chatType Тип чата
 * @param userId ID пользователя, если сообщение было отправлено пользователю
 * @author SuperSevenPro55
 * @version 0.2
 */

public record Recipient(
    @JsonProperty("chat_id")
    Long chatId,

    @JsonProperty("chat_type")
    @NonNull
    ChatType chatType,

    @JsonProperty("user_id")
    Long userId
) implements MaxApiObject {}
