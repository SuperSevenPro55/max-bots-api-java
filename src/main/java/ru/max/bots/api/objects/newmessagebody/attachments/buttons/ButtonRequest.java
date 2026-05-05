package ru.max.bots.api.objects.newmessagebody.attachments.buttons;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.max.bots.api.objects.MaxApiObject;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CallbackButtonRequest.class, name = "callback"),
        @JsonSubTypes.Type(value = LinkButtonRequest.class, name = "link"),
        @JsonSubTypes.Type(value = RequestGeoLocationButtonRequest.class, name = "request_geo_location"),
        @JsonSubTypes.Type(value = RequestContactButtonRequest.class, name = "request_contact"),
        @JsonSubTypes.Type(value = OpenAppButtonRequest.class, name = "open_app"),
        @JsonSubTypes.Type(value = MessageButtonRequest.class, name = "message"),
        @JsonSubTypes.Type(value = ClipboardButtonRequest.class, name = "clipboard")
})
public interface ButtonRequest extends MaxApiObject {
}
