package ru.max.bots.api.objects.message.body.markup;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.max.bots.api.objects.MaxApiObject;

/**
 * Интерфейс для всех разметок
 * @author SuperSevenPro55
 * @version 0.2
 */

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true,
        defaultImpl = UnknownMarkupElement.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleMarkupElement.class, name = "strong"),
        @JsonSubTypes.Type(value = SimpleMarkupElement.class, name = "emphasized"),
        @JsonSubTypes.Type(value = SimpleMarkupElement.class, name = "monospaced"),
        @JsonSubTypes.Type(value = SimpleMarkupElement.class, name = "strikethrough"),
        @JsonSubTypes.Type(value = SimpleMarkupElement.class, name = "underline"),

        @JsonSubTypes.Type(value = LinkMarkupElement.class, name = "link"),
        @JsonSubTypes.Type(value = UserMentionMarkupElement.class, name = "user_mention"),
})
public interface MarkupElement extends MaxApiObject {
    String type();
    Integer from();
    Integer length();
}
