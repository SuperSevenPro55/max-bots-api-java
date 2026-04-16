package ru.max.bots.api.objects.message.helpers.body.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import ru.max.bots.api.interfaces.MaxApiObject;

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
