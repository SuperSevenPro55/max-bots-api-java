package ru.max.bots.api.objects.newmessagebody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import ru.max.bots.api.objects.MaxApiObject;
import ru.max.bots.api.objects.newmessagebody.attachments.AttachmentRequest;
import ru.max.bots.api.objects.newmessagebody.format.TextFormat;
import ru.max.bots.api.objects.newmessagebody.link.NewMessageLink;

import java.util.List;

/**
 * Объект для отправки нового сообщения
 * @author SuperSevenPro55
 * @version 0.2
 */

@Data
@Jacksonized
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewMessageBody implements MaxApiObject {
    public static final String TEXT = "text";
    public static final String ATTACHMENTS = "attachments";
    public static final String LINK = "link";
    public static final String NOTIFY = "notify";
    public static final String FORMAT = "format";
    /**
     * Новый текст сообщения. До 4000 символов.
     */
    @JsonProperty(TEXT)
    private String text;

    /**
     * Вложения сообщения. Если пусто, все вложения будут удалены
     */
    @JsonProperty(ATTACHMENTS)
    private List<AttachmentRequest> attachments;

    /**
     *
     */
    @JsonProperty(LINK)
    private NewMessageLink link;

    /**
     * По умолчанию: true
     * Если false, участники чата не будут уведомлены (по умолчанию true).
     * Опционально.
     */
    @JsonProperty(NOTIFY)
    private Boolean notify = true;

    /**
     * Если установлен, текст сообщения будет форматирован данным способом
     */
    @JsonProperty(FORMAT)
    private TextFormat format;

}
