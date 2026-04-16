package ru.max.bots.api.objects.message.helpers.body.attachment.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Вложение ссылки (поделиться)
 * @param url URL, прикрепленный к сообщению в качестве предпросмотра медиа. Опционально. От 1 символа
 * @param token токен вложения
 */

public record ShareAttachmentPayload(
        @JsonProperty("url")
        String url,

        @JsonProperty("token")
        String token
) implements AttachmentPayload {}
