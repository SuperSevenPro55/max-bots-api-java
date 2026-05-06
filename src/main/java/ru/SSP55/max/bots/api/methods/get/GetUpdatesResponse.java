package ru.SSP55.max.bots.api.methods.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.SSP55.max.bots.api.objects.MaxApiObject;
import ru.SSP55.max.bots.api.objects.update.Update;

import java.util.List;

@Data
public class GetUpdatesResponse implements MaxApiObject {
    @JsonProperty("updates")
    private List<Update> updates;

    @JsonProperty("marker")
    private Long marker;
}