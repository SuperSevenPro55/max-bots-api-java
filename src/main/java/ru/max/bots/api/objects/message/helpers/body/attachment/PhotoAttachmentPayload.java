package ru.max.bots.api.objects.message.helpers.body.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;

/**
 * Содержимое вложения типа "image"
 * @param photoId Уникальный ID этого изображения
 * @param token
 * @param url URL изображения
 * @author SuperSevenPro55
 * @version 0.2
 */

public record PhotoAttachmentPayload(
        @JsonProperty("photo_id")
        @NonNull
        Long photoId,

        @JsonProperty("token")
        String token,

        @JsonProperty("url")
        String url
) implements AttachmentPayload {}
