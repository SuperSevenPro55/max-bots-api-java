package ru.ssp55.max.bots.api.method.message;

import lombok.Builder;
import ru.ssp55.max.bots.api.method.HttpMethod;
import ru.ssp55.max.bots.api.method.MaxRequest;
import ru.ssp55.max.bots.api.model.message.NewMessageBody;
import tools.jackson.core.type.TypeReference;

import java.util.HashMap;
import java.util.Map;

@Builder
public class SendMessage implements MaxRequest<SendMessageResponse> {
    private final Long userId;
    private final Long chatId;
    private final Boolean disableLinkPreview;
    private final NewMessageBody body;

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }

    @Override
    public String getEndpoint() {
        return "/messages";
    }

    @Override
    public Map<String, Object> getQueryParams() {
        Map<String, Object> params = new HashMap<>();
        if (userId != null) {
            params.put("user_id", userId);
        }
        if (chatId != null) {
            params.put("chat_id", chatId);
        }
        if (disableLinkPreview != null) {
            params.put("disable_link_preview", disableLinkPreview);
        }
        return params;
    }

    @Override
    public Object getBody() {
        return body;
    }

    @Override
    public TypeReference<SendMessageResponse> getResponseType() {
        return new TypeReference<>() {};
    }
}