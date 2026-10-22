package ru.SSP55.max.bots.api.objects.newmessagebody.attachments.payloads;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PhotoAttachmentRequestPayload(
        @JsonProperty("url")
        String url,

        @JsonProperty("token")
        String token,

        @JsonProperty("photos")
        Photos photos
) implements AttachmentPayloadRequest {
        public static PhotoAttachmentRequestPayload fromUrl(String url) {
                return new PhotoAttachmentRequestPayload(url, null, null);
        }

        public static PhotoAttachmentRequestPayload fromToken(String token) {
                return new PhotoAttachmentRequestPayload(null, token, null);
        }

        public static PhotoAttachmentRequestPayload fromUploaded(String photoToken) {
                return new PhotoAttachmentRequestPayload(null, null, new Photos(photoToken));
        }
}

record Photos(
        @JsonProperty("token")
        String token
) {}