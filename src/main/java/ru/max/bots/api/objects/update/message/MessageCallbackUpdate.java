package ru.max.bots.api.objects.update.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.max.bots.api.objects.message.Message;

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageCallbackUpdate extends MessageUpdate {
    @JsonProperty("callback")
    private Callback callback;

    @JsonProperty("message")
    private Message message;

    @JsonProperty("user_locale")
    private String userLocale;
}
