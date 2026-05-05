package ru.max.bots.api.objects.update.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.max.bots.api.objects.update.Update;
import ru.max.bots.api.objects.user.User;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class ChatUpdate extends Update {
    @JsonProperty("chat_id")
    private Long chatId;

    @JsonProperty("user")
    private User user;
}
