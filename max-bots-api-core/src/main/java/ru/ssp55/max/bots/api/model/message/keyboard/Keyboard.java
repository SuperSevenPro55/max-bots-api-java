package ru.ssp55.max.bots.api.model.message.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.ssp55.max.bots.api.model.message.attachment.payload.AttachmentPayload;
import ru.ssp55.max.bots.api.model.message.attachment.request.AttachmentPayloadRequest;

import java.util.List;

public record Keyboard(
        @JsonProperty("buttons")
        List<List<Button>> buttons
) implements AttachmentPayload, AttachmentPayloadRequest {}
