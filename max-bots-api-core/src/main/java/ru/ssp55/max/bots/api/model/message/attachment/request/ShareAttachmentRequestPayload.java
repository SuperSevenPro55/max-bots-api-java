package ru.ssp55.max.bots.api.model.message.attachment.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ShareAttachmentRequestPayload(
        @JsonProperty("url")
        String url,

        @JsonProperty("token")
        String token
) implements AttachmentPayloadRequest {}
