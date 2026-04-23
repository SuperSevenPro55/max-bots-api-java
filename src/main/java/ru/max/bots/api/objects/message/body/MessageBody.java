package ru.max.bots.api.objects.message.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import ru.max.bots.api.objects.MaxApiObject;
import ru.max.bots.api.objects.message.body.attachments.Attachment;
import ru.max.bots.api.objects.message.body.markup.MarkupElement;

import java.util.List;

/**
 * Содержимое сообщения. Текст + вложения. Может быть null, если сообщение содержит только пересланное сообщение
 * @param mid Уникальный ID сообщения
 * @param seq ID последовательности сообщения в чате
 * @param text Новый текст сообщения
 * @param attachments Вложения сообщения. Могут быть одним из типов Attachment.
 * @param markups Разметка текста сообщения.
 */

public record MessageBody(
        @JsonProperty("mid")
        @NonNull
        String mid,

        @JsonProperty("seq")
        @NonNull
        Long seq,

        @JsonProperty("text")
        String text,

        @JsonProperty("attachments")
        List<Attachment> attachments,

        @JsonProperty("markup")
        List<MarkupElement> markups

) implements MaxApiObject {}
