package ru.ssp55.max.bots.api.model.message.attachment.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.ssp55.max.bots.api.model.MaxApiObject;
import ru.ssp55.max.bots.api.model.message.keyboard.Button;
import ru.ssp55.max.bots.api.model.message.keyboard.Keyboard;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachmentRequest implements MaxApiObject {

    @JsonProperty("type")
    private String type;

    @JsonProperty("payload")
    private AttachmentPayloadRequest payload;

    public static AttachmentRequest photo(PhotoAttachmentRequestPayload payload) {
        return new AttachmentRequest("image", payload);
    }

    public static AttachmentRequest photoFromUrl(String url) {
        return photo(PhotoAttachmentRequestPayload.fromUrl(url));
    }

    public static AttachmentRequest photoFromToken(String token) {
        return photo(PhotoAttachmentRequestPayload.fromToken(token));
    }

    public static AttachmentRequest video(UploadedInfo payload) {
        return new AttachmentRequest("video", payload);
    }

    public static AttachmentRequest video(String token) {
        return video(new UploadedInfo(token));
    }

    public static AttachmentRequest audio(UploadedInfo payload) {
        return new AttachmentRequest("audio", payload);
    }

    public static AttachmentRequest audio(String token) {
        return audio(new UploadedInfo(token));
    }

    public static AttachmentRequest file(UploadedInfo payload) {
        return new AttachmentRequest("file", payload);
    }

    public static AttachmentRequest file(String token) {
        return file(new UploadedInfo(token));
    }

    public static AttachmentRequest sticker(StickerAttachmentRequestPayload payload) {
        return new AttachmentRequest("sticker", payload);
    }

    public static AttachmentRequest sticker(String code) {
        return sticker(new StickerAttachmentRequestPayload(code));
    }

    public static AttachmentRequest contact(ContactAttachmentRequestPayload payload) {
        return new AttachmentRequest("contact", payload);
    }

    public static AttachmentRequest location(Double latitude, Double longitude) {
        return new LocationAttachmentRequest(latitude, longitude);
    }

    public static AttachmentRequest share(ShareAttachmentRequestPayload payload) {
        return new AttachmentRequest("share", payload);
    }

    public static AttachmentRequest inlineKeyboard(Keyboard keyboard) {
        return new AttachmentRequest("inline_keyboard", keyboard);
    }

    public static AttachmentRequest inlineKeyboard(List<List<Button>> buttons) {
        return inlineKeyboard(new Keyboard(buttons));
    }
}