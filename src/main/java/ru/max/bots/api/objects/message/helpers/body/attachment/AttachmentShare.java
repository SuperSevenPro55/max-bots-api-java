package ru.max.bots.api.objects.message.helpers.body.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Вложение ссылка (поделиться)
 * @author SuperSevenPro55
 * @version 0.2
 */

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AttachmentShare extends Attachment {
    /**
     * Заголовок предпросмотра ссылки.
     */
    @JsonProperty("title")
    private String title;

    /**
     * Описание предпросмотра ссылки.
     */
    @JsonProperty("description")
    private String description;

    /**
     * Изображение предпросмотра ссылки.
     */
    @JsonProperty("image_url")
    private String imageUrl;
}
