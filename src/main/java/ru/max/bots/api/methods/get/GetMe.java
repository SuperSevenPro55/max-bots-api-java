package ru.max.bots.api.methods.get;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Request;
import ru.max.bots.api.methods.MaxRequest;
import ru.max.bots.api.objects.user.BotInfo;

/**
 * Метод возвращает информацию о боте, который идентифицируется с помощью токена доступа access_token.
 * В ответе приходит объект User с вариантом наследования BotInfo,
 * который содержит идентификатор бота, его название, никнейм, время последней активности, описание и аватар (при наличии)
 * @author SuperSevenPro55
 * @version 0.1
 */

public class GetMe implements MaxRequest<BotInfo> {
    @Override
    public Request buildRequest(String baseUrl, String token, ObjectMapper objectMapper) {
        return new Request.Builder()
                .header("Authorization", token)
                .url(baseUrl + "/me")
                .get()
                .build();
    }

    @Override
    public Class<BotInfo> getResponseType() {
        return BotInfo.class;
    }
}
