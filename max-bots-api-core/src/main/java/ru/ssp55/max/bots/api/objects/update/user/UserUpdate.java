package ru.ssp55.max.bots.api.objects.update.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.ssp55.max.bots.api.objects.update.Update;
import ru.ssp55.max.bots.api.objects.user.User;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class UserUpdate extends Update {
    @JsonProperty("chat_id")
    private Long chatId;

    @JsonProperty("user")
    private User user;

    @JsonProperty("is_channel")
    private Boolean isChannel;
}
