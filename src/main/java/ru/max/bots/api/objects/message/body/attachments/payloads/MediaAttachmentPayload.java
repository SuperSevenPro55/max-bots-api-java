package ru.max.bots.api.objects.message.body.attachments.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;

/**
 * Медиа-вложение
 * @param url URL медиа-вложения. Этот URL будет получен в объекте Update после отправки сообщения в чат.
 * @param token Используйте token, если вы пытаетесь повторно использовать одно и то же вложение в другом сообщении.
 * @author SuperSevenPro55
 * @version 0.2
 */

public record MediaAttachmentPayload(
        @JsonProperty("url")
        @NonNull
        String url,

        @JsonProperty("token")
        @NonNull
        String token
) implements AttachmentPayload {}
