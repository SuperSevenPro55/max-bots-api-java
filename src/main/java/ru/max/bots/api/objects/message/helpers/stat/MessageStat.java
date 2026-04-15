package ru.max.bots.api.objects.message.helpers.stat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import ru.max.bots.api.interfaces.MaxApiObject;

/**
 * Статистика сообщения. Возвращается только для постов в каналах
 * @param views Количество пользователей, которые увидели пост в канале. Просмотр засчитывается, когда пост попадает в область видимости экрана
 * @author SuperSevenPro55
 * @version 0.2
 */

public record MessageStat(
        @JsonProperty("views")
        @NonNull
        Long views
) implements MaxApiObject {}
