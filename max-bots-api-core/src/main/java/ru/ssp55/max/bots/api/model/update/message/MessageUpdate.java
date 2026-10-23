package ru.ssp55.max.bots.api.model.update.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.ssp55.max.bots.api.model.update.Update;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class MessageUpdate extends Update {
}
