package ru.max.bots.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.max.bots.api.objects.message.Message;

/**
 * Объект, представляющий входящее обновление от сервера MAX.
 */
@Data
public class Update implements MaxApiObject {

    @JsonProperty("update_id")
    private long updateId;

    /**
     * Новое входящее сообщение.
     * Если в будущем добавятся нажатия кнопок (callback), они добавятся сюда же.
     */
    @JsonProperty("message")
    private Message message;
}