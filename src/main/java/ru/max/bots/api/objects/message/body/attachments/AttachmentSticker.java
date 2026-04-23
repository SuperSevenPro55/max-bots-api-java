package ru.max.bots.api.objects.message.body.attachments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Вложение-стикер
 * @author SuperSevenPro55
 * @version 0.2
 */

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AttachmentSticker extends Attachment {
    /**
     * Ширина стикера
     */
    @JsonProperty("width")
    private Integer width;

    /**
     * Высота стикера
     */
    @JsonProperty("height")
    private Integer height;
}
