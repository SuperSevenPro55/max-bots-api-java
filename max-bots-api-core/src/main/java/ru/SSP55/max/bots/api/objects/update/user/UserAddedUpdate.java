package ru.SSP55.max.bots.api.objects.update.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAddedUpdate extends UserUpdate{
    @JsonProperty("inviter_id")
    private Long inviterId;
}
