package ru.max.bots.api.objects.message.helpers.body.attachment;

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
@JsonSubTypes(
        @JsonSubTypes.Type(value = PhotoAttachmentPayload.class, name = "image")
)
public interface AttachmentPayload extends MaxApiObject {
}
