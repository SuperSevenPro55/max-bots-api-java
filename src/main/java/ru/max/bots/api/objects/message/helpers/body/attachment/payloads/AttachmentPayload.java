package ru.max.bots.api.objects.message.helpers.body.attachment.payloads;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.max.bots.api.interfaces.MaxApiObject;

/**
 * Базовый интерфейс для всех вложений
 * @author SuperSevenPro55
 * @version 0.2
 */

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "type",
        defaultImpl = UnknownAttachmentPayload.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PhotoAttachmentPayload.class, name = "image"),
        @JsonSubTypes.Type(value = MediaAttachmentPayload.class, name = "video"),
        @JsonSubTypes.Type(value = MediaAttachmentPayload.class, name = "audio"),
        @JsonSubTypes.Type(value = FileAttachmentPayload.class, name = "file"),
        @JsonSubTypes.Type(value = StickerAttachmentPayload.class, name = "sticker"),
        @JsonSubTypes.Type(value = ContactAttachmentPayload.class, name = "contact"),
        @JsonSubTypes.Type(value = ShareAttachmentPayload.class, name = "share")

})
public interface AttachmentPayload extends MaxApiObject {
}
