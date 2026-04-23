package ru.max.bots.api.objects.message.body.attachments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Аудио-вложение
 * @author SuperSevenPro55
 * @version 0.2
 */

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AttachmentAudio extends Attachment {
    /**
     * Аудио транскрипция
     */
    @JsonProperty("transcription")
    private String transcription;
}
