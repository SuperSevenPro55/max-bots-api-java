package ru.ssp55.max.bots.api.model.message.attachment.payload;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.ssp55.max.bots.api.model.MaxApiObject;
import ru.ssp55.max.bots.api.model.message.keyboard.Keyboard;

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
        @JsonSubTypes.Type(value = MediaAttachmentPayload.class, name = "file"),
        @JsonSubTypes.Type(value = StickerAttachmentPayload.class, name = "sticker"),
        @JsonSubTypes.Type(value = ContactAttachmentPayload.class, name = "contact"),
        @JsonSubTypes.Type(value = MediaAttachmentPayload.class, name = "share"),
        @JsonSubTypes.Type(value = Keyboard.class, name = "inline_keyboard")
})
public interface AttachmentPayload extends MaxApiObject {
}
