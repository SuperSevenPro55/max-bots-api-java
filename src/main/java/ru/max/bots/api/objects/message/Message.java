package ru.max.bots.api.objects.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import ru.max.bots.api.interfaces.MaxApiObject;
import ru.max.bots.api.objects.message.helpers.link.LinkedMessage;
import ru.max.bots.api.objects.message.helpers.body.MessageBody;
import ru.max.bots.api.objects.message.helpers.stat.MessageStat;
import ru.max.bots.api.objects.message.helpers.recipient.Recipient;
import ru.max.bots.api.objects.user.User;

/**
 * Сообщение в чате.
 * @author SuperSevenPro
 * @version 0.2
 */

@Data
@Jacksonized
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message implements MaxApiObject {
    private static final String SENDER = "sender";
    private static final String RECIPIENT = "recipient";
    private static final String TIMESTAMP = "timestamp";
    private static final String LINK = "link";
    private static final String BODY = "body";
    private static final String STAT = "stat";
    private static final String URL = "url";

    /**
     * Пользователь, отправивший сообщение. Опционально.
     */
    @JsonProperty(SENDER)
    private User sender;

    /**
     * Получатель сообщения. Может быть пользователем или чатом.
     */
    @JsonProperty(RECIPIENT)
    @NonNull
    private Recipient recipient;

    /**
     * Время создания сообщения в формате Unix-time (мс).
     */
    @JsonProperty(TIMESTAMP)
    @NonNull
    private Long timestamp;

    /**
     * Пересланное или ответное сообщение. Опционально.
     */
    @JsonProperty(LINK)
    private LinkedMessage link;

    /**
     * Содержимое сообщения. Текст + вложения.
     * Может быть null, если сообщение содержит только пересланное сообщение.
     */
    @JsonProperty(BODY)
    private MessageBody body;

    /**
     * Статистика сообщения. Возвращается только для постов в каналах. Опционально.
     */
    @JsonProperty(STAT)
    private MessageStat stat;

    /**
     * Публичная ссылка на пост в канале. Отсутствует для диалогов и групповых чатов. Опционально.
     */
    @JsonProperty(URL)
    private String url;
}
