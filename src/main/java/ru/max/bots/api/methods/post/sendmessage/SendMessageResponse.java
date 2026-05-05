package ru.max.bots.api.methods.post.sendmessage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.max.bots.api.objects.message.Message;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendMessageResponse {

    @JsonProperty("message")
    private Message message;

}