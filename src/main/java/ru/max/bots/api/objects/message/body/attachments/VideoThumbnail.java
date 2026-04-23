package ru.max.bots.api.objects.message.body.attachments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import ru.max.bots.api.objects.MaxApiObject;

/**
 * Миниатюра видео
 * @param url URL изображения
 * @author SuperSevenPro55
 * @version 0.2
 */

public record VideoThumbnail(
        @JsonProperty("url")
        @NonNull
        String url
) implements MaxApiObject {
}
