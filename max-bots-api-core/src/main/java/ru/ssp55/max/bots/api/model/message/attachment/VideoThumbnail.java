package ru.ssp55.max.bots.api.model.message.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import ru.ssp55.max.bots.api.model.MaxApiObject;

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
