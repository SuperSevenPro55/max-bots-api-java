package ru.max.bots.api.objects.newmessagebody.attachments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.max.bots.api.objects.MaxApiObject;
import ru.max.bots.api.objects.newmessagebody.attachments.payloads.AttachmentPayloadRequest;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentRequest implements MaxApiObject {
    @JsonProperty("type")
    private String type;

    @JsonProperty("payload")
    AttachmentPayloadRequest payload;
}
