package ru.max.bots.api.objects.newmessagebody.attachments.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.max.bots.api.objects.newmessagebody.attachments.buttons.ButtonRequest;

import java.util.List;

public record InlineKeyboardAttachmentRequestPayload(
        @JsonProperty("buttons")
        List<List<ButtonRequest>> buttons
) implements AttachmentPayloadRequest {}
