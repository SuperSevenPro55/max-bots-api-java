package ru.max.bots.api.objects.message.body.attachments.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.max.bots.api.objects.message.body.attachments.buttons.Button;

import java.util.List;

public record Keyboard(
        @JsonProperty("buttons")
        List<List<Button>> buttons
) implements AttachmentPayload {}
