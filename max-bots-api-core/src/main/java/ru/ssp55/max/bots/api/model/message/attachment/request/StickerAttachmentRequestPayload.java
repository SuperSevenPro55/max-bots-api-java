package ru.ssp55.max.bots.api.model.message.attachment.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StickerAttachmentRequestPayload(
        @JsonProperty("code")
        String code
) implements AttachmentPayloadRequest {}
