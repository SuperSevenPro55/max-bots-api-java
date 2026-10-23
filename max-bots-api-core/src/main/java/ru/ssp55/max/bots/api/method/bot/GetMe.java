package ru.ssp55.max.bots.api.method.bot;

import tools.jackson.core.type.TypeReference;
import ru.ssp55.max.bots.api.method.HttpMethod;
import ru.ssp55.max.bots.api.method.MaxRequest;
import ru.ssp55.max.bots.api.model.user.BotInfo;

/**
 * Метод возвращает информацию о боте, который идентифицируется с помощью токена доступа access_token.
 * В ответе приходит объект User с вариантом наследования BotInfo,
 * который содержит идентификатор бота, его название, никнейм, время последней активности, описание и аватар (при наличии)
 * @author SuperSevenPro55
 * @version 0.1
 */

public class GetMe implements MaxRequest<BotInfo> {
    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getEndpoint() {
        return "/me";
    }

    @Override
    public TypeReference<BotInfo> getResponseType() {
        return new TypeReference<>() {};
    }
}