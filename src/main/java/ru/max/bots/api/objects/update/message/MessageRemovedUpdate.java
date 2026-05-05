package ru.max.bots.api.objects.update.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageRemovedUpdate extends MessageUpdate {
    @JsonProperty("message_id")
    private String messageId;

    @JsonProperty("chat_id")
    private Long chatId;

    @JsonProperty("user_id")
    private Long userId;
}
