package ru.SSP55.max.bots.api.objects.newmessagebody.attachments.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ShareAttachmentRequestPayload(
        @JsonProperty("url")
        String url,

        @JsonProperty("token")
        String token
) implements AttachmentPayloadRequest {}
