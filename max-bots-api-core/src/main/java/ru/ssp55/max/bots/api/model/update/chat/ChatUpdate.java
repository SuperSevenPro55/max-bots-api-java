package ru.ssp55.max.bots.api.model.update.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.ssp55.max.bots.api.model.update.Update;
import ru.ssp55.max.bots.api.model.user.User;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class ChatUpdate extends Update {
    @JsonProperty("chat_id")
    private Long chatId;

    @JsonProperty("user")
    private User user;
}
