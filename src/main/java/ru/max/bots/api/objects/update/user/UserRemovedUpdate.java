package ru.max.bots.api.objects.update.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserRemovedUpdate extends UserUpdate {
    @JsonProperty("admin_id")
    private Long adminId;
}
