package ru.ssp55.max.bots.api.model.message.attachment.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UploadedInfo(
        @JsonProperty("token")
        String token
) implements AttachmentPayloadRequest {}
