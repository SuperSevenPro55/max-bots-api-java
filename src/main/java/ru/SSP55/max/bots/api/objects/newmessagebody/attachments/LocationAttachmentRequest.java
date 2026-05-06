package ru.SSP55.max.bots.api.objects.newmessagebody.attachments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LocationAttachmentRequest extends AttachmentRequest {

    @JsonProperty("latitude")
    private Double latitude;

    @JsonProperty("longitude")
    private Double longitude;

    public LocationAttachmentRequest(Double latitude, Double longitude) {
        super("location", null);
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
