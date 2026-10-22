package ru.SSP55.max.bots.api.objects.update.bot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.SSP55.max.bots.api.objects.update.Update;
import ru.SSP55.max.bots.api.objects.user.User;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BotUpdate extends Update {
    @JsonProperty("chat_id")
    private Long chatId;

    @JsonProperty("user")
    private User user;
}
