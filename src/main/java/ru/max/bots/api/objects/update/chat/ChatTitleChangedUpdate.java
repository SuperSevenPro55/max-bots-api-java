package ru.max.bots.api.objects.update.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChatTitleChangedUpdate extends ChatUpdate {
    @JsonProperty("title")
    private String title;
}
