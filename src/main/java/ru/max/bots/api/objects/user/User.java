package ru.max.bots.api.objects.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import ru.max.bots.api.interfaces.MaxApiObject;

/**
 * Объект, описывающий один из вариантов наследования:
 * <p>
 * User (содержит общую информацию о пользователе или боте без аватара),
 * <p>
 * UserWithPhoto (объект с общей информацией о пользователе или боте, дополнительно содержит URL аватара и описание),
 * <p>
 * BotInfo (объект включает общую информацию о боте, URL аватара и описание. Дополнительно содержит список команд, поддерживаемых ботом.
 * Возвращается только при вызове метода GET /me),
 * <p>
 * ChatMember (объект включает общую информацию о пользователе или боте, URL аватара и описание при его наличии.
 * Дополнительно содержит данные для пользователей-участников чата.
 * Возвращается только при вызове некоторых методов группы /chats)
 * @author SuperSevenPro55
 * @version 0.1
 */

@Data
@SuperBuilder
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements MaxApiObject {
    private static final String USER_ID = "user_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String USERNAME = "username";
    private static final String IS_BOT = "is_bot";
    private static final String LAST_ACTIVITY_TIME = "last_activity_time";
    private static final String NAME = "name";

    /**
     * Идентификатор пользователя или бота.
     */
    @JsonProperty(USER_ID)
    @NonNull
    private Long userId;

    /**
     * Отображаемое имя пользователя или бота.
     */
    @JsonProperty(FIRST_NAME)
    @NonNull
    private String firstName;

    /**
     * Опционально.
     * Отображаемая фамилия пользователя. Для ботов это поле не возвращается
     */
    @JsonProperty(LAST_NAME)
    private String lastName;

    /**
     * Никнейм бота или уникальное публичное имя пользователя.
     * В случае с пользователем может быть null, если тот недоступен или имя не задано
     */
    @JsonProperty(USERNAME)
    private String username;

    /**
     * true, если это бот
     */
    @JsonProperty(IS_BOT)
    @NonNull
    private Boolean isBot;

    /**
     * Время последней активности пользователя или бота в MAX (Unix-время в миллисекундах).
     * Если пользователь отключил в настройках профиля мессенджера MAX возможность видеть,
     * что он в сети онлайн, поле может не возвращаться
     */
    @JsonProperty(LAST_ACTIVITY_TIME)
    private Long lastActivityTime;

    /**
     * @deprecated Устаревшее поле, скоро будет удалено
     */
    @JsonProperty(NAME)
    @Deprecated
    private String name;
}
