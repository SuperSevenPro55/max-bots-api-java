package ru.max.bots.api.objects.newmessagebody.attachments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.max.bots.api.objects.MaxApiObject;
import ru.max.bots.api.objects.newmessagebody.attachments.payloads.AttachmentPayloadRequest;
import ru.max.bots.api.objects.newmessagebody.attachments.payloads.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachmentRequest implements MaxApiObject {
    @JsonProperty("type")
    private String type;

    @JsonProperty("payload")
    AttachmentPayloadRequest payload;

    public static AttachmentRequest photo(PhotoAttachmentRequestPayload payload) {
        return new AttachmentRequest("image", payload);
    }

    public static AttachmentRequest video(UploadedInfo payload) {
        return new AttachmentRequest("video", payload);
    }

    public static AttachmentRequest audio(UploadedInfo payload) {
        return new AttachmentRequest("audio", payload);
    }

    public static AttachmentRequest file(UploadedInfo payload) {
        return new AttachmentRequest("file", payload);
    }

    public static AttachmentRequest sticker(StickerAttachmentRequestPayload payload) {
        return new AttachmentRequest("sticker", payload);
    }

    public static AttachmentRequest contact(ContactAttachmentRequestPayload payload) {
        return new AttachmentRequest("contact", payload);
    }

    public static AttachmentRequest inlineKeyboard(InlineKeyboardAttachmentRequestPayload payload) {
        return new AttachmentRequest("inline_keyboard", payload);
    }

    public static AttachmentRequest location(Double latitude, Double longitude) {
        return new LocationAttachmentRequest(latitude, longitude);
    }

    public static AttachmentRequest share(ShareAttachmentRequestPayload payload) {
        return new AttachmentRequest("share", payload);
    }
}
