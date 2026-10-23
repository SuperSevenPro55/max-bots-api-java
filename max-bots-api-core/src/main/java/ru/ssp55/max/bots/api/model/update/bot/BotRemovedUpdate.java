package ru.ssp55.max.bots.api.model.update.bot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BotRemovedUpdate extends BotUpdate {
    @JsonProperty("is_channel")
    private Boolean isChannel;
}
