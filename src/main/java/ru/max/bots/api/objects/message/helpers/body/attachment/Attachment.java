package ru.max.bots.api.objects.message.helpers.body.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import ru.max.bots.api.interfaces.MaxApiObject;

/**
 * Обертка для вложений сообщения.
 * @param type тип вложения
 * @param payload содержимое вложения
 * @author SuperSevenPro55
 * @version 0.2
 */

public record Attachment(
    @JsonProperty("type")
    @NonNull
    String type,

    @JsonProperty("payload")
    @NonNull
    AttachmentPayload payload
) implements MaxApiObject {}
