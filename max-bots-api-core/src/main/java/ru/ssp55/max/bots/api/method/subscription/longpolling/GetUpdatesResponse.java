package ru.ssp55.max.bots.api.method.subscription.longpolling;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.ssp55.max.bots.api.model.MaxApiObject;
import ru.ssp55.max.bots.api.objects.update.Update;

import java.util.List;

@Data
public class GetUpdatesResponse implements MaxApiObject {
    @JsonProperty("updates")
    private List<Update> updates;

    @JsonProperty("marker")
    private Long marker;
}