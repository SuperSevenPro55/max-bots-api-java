package ru.ssp55.max.bots.api.model.message.attachment.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ContactAttachmentRequestPayload(
        @JsonProperty("name")
        String name,

        @JsonProperty("contact_id")
        Long contactId,

        @JsonProperty("vcf_info")
        String vcfInfo,

        @JsonProperty("vcf_phone")
        String vcfPhone
) implements AttachmentPayloadRequest {}
