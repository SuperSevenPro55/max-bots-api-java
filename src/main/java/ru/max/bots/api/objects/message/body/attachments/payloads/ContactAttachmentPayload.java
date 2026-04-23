package ru.max.bots.api.objects.message.body.attachments.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.max.bots.api.objects.user.User;

/**
 * Вложение контакта
 * @param vcfInfo Информация о пользователе в формате VCF.
 * @param maxInfo Информация о пользователе.
 * @author SuperSevenPro55
 * @version 0.2
 */

public record ContactAttachmentPayload(
        @JsonProperty("vcf_info")
        String vcfInfo,

        @JsonProperty("max_info")
        User maxInfo
) implements AttachmentPayload {}
