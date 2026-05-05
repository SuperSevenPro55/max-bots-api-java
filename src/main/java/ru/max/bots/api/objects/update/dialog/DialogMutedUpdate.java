package ru.max.bots.api.objects.update.dialog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DialogMutedUpdate extends DialogUpdate {
    @JsonProperty("muted_until")
    private Long mutedUntil;
}
