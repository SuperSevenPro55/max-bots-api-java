package ru.SSP55.max.bots.api.objects.message.body.attachments;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Вложение контакта
 * @author SuperSevenPro55
 * @version 0.2
 */

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AttachmentContact extends Attachment {
}
