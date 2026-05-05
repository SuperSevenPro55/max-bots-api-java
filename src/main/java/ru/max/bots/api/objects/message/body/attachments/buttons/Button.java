package ru.max.bots.api.objects.message.body.attachments.buttons;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.max.bots.api.objects.MaxApiObject;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        defaultImpl = UnknownButton.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CallbackButton.class, name = "callback"),
        @JsonSubTypes.Type(value = LinkButton.class, name = "link"),
        @JsonSubTypes.Type(value = RequestGeoLocationButton.class, name = "request_geo_location"),
        @JsonSubTypes.Type(value = RequestContactButton.class, name = "request_contact"),
        @JsonSubTypes.Type(value = OpenAppButton.class, name = "open_app"),
        @JsonSubTypes.Type(value = MessageButton.class, name = "message"),
        @JsonSubTypes.Type(value = ClipboardButton.class, name = "clipboard")
})
public interface Button extends MaxApiObject {
}
