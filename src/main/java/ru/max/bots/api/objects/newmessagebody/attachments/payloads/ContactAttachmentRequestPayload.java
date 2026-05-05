package ru.max.bots.api.objects.newmessagebody.attachments.payloads;

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
