package ru.max.bots.api.methods.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.max.bots.api.objects.MaxApiObject;
import ru.max.bots.api.objects.Update;

import java.util.List;

@Data
public class GetUpdatesResponse implements MaxApiObject {
    @JsonProperty("updates")
    private List<Update> updates;

    // Тот самый маркер, который мы будем передавать в следующий запрос!
    @JsonProperty("marker")
    private Long marker;
}