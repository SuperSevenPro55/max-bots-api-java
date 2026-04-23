package ru.max.bots.api.objects.message.body.attachments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Вложение-видео
 * @author SuperSevenPro55
 * @version 0.2
 */

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AttachmentVideo extends Attachment {
    /**
     * Миниатюра видео. Опционально.
     */
    @JsonProperty("thumbnail")
    private VideoThumbnail thumbnail;

    /**
     * Ширина видео. Опционально.
     */
    @JsonProperty("width")
    private Integer width;

    /**
     * Высота видео. Опционально.
     */
    @JsonProperty("height")
    private Integer height;

    /**
     * Длина видео в секундах. Опционально.
     */
    @JsonProperty("duration")
    private Integer duration;
}
