package ru.ssp55.max.bots.api.objects.newmessagebody.attachments.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StickerAttachmentRequestPayload(
        @JsonProperty("code")
        String code
) implements AttachmentPayloadRequest {}
