package ru.ssp55.max.bots.api.method.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.ssp55.max.bots.api.objects.message.Message;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendMessageResponse {

    @JsonProperty("message")
    private Message message;

}