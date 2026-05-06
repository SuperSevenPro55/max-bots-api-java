package ru.SSP55.max.bots.api.objects.update.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.SSP55.max.bots.api.objects.update.Update;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class MessageUpdate extends Update {
}
