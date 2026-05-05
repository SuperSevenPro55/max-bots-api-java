package ru.max.bots.api.objects.message.body.attachments;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;
import ru.max.bots.api.objects.MaxApiObject;
import ru.max.bots.api.objects.message.body.attachments.payloads.AttachmentPayload;

/**
 * Общая обертка для вложений сообщения.
 * @author SuperSevenPro55
 * @version 0.2
 */

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true,
        defaultImpl = Attachment.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AttachmentAudio.class, name = "audio"),
        @JsonSubTypes.Type(value = AttachmentFile.class, name = "file"),
        @JsonSubTypes.Type(value = AttachmentVideo.class, name = "video"),
        @JsonSubTypes.Type(value = AttachmentSticker.class, name = "sticker"),
        @JsonSubTypes.Type(value = AttachmentContact.class, name = "contact"),
        @JsonSubTypes.Type(value = AttachmentShare.class, name = "share"),
        @JsonSubTypes.Type(value = AttachmentInlineKeyboard.class, name = "inline_keyboard"),
        @JsonSubTypes.Type(value = AttachmentLocation.class, name = "location")
})
public class Attachment implements MaxApiObject {
    /**
     * Тип вложения.
     */
    @JsonProperty("type")
    @NonNull
    private String type;

    /**
     * Содержание вложения.
     */
    @JsonProperty("payload")
    private AttachmentPayload payload;
}
