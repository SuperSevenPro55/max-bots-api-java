package ru.SSP55.max.bots.api.methods.post.sendmessage;

import lombok.Builder;
import ru.SSP55.max.bots.api.methods.HttpMethod;
import ru.SSP55.max.bots.api.methods.MaxRequest;
import ru.SSP55.max.bots.api.objects.newmessagebody.NewMessageBody;
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