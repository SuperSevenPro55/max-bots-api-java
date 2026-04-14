package ru.max.bots.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 *  Включает общую информацию о боте, URL аватара и описание. Дополнительно содержит список команд, поддерживаемых ботом.
 *  Возвращается только при вызове метода GET /me.
 * @author SuperSevenPro55
 * @version 0.1
 */

@Data
@SuperBuilder
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BotInfo extends User {
    private static final String DESCRIPTION = "description";
    private static final String AVATAR_URL = "avatar_url";
    private static final String FULL_AVATAR_URL = "full_avatar_url";
    private static final String COMMANDS = "commands";

    /**
     * Описание пользователя или бота. В случае с пользователем может принимать значение null, если описание не заполнено.
     * До 16000 символов. Опционально.
     */
    @JsonProperty(DESCRIPTION)
    private String description;

    /**
     * URL аватара пользователя или бота в уменьшенном размере. Опционально.
     */
    @JsonProperty(AVATAR_URL)
    private String avatarUrl;

    /**
     * URL аватара пользователя или бота в полном размере. Опционально.
     */
    @JsonProperty(FULL_AVATAR_URL)
    private String fullAvatarUrl;

    /**
     * Команды, поддерживаемые ботом. До 32 элементов. Опционально.
     */
    @JsonProperty(COMMANDS)
    private List<BotCommand> commands;
}
