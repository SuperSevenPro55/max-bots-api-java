package ru.max.bots.api.objects.message.body.attachments.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;

/**
 * Вложение-стикер
 * @param url URL медиа-вложения. Этот URL будет получен в объекте Update после отправки сообщения в чат.
 * @param code ID стикера
 */

public record StickerAttachmentPayload(
        @JsonProperty("url")
        @NonNull
        String url,

        @JsonProperty("code")
        @NonNull
        String code
) implements AttachmentPayload {}
