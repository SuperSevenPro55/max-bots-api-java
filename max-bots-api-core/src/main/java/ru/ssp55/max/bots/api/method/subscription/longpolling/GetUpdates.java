package ru.ssp55.max.bots.api.method.subscription.longpolling;

import lombok.Builder;
import ru.ssp55.max.bots.api.method.HttpMethod;
import ru.ssp55.max.bots.api.method.MaxRequest;
import tools.jackson.core.type.TypeReference;

import java.util.HashMap;
import java.util.Map;

@Builder
public class GetUpdates implements MaxRequest<GetUpdatesResponse> {
    private final Long offset;
    private final Integer timeout;

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getEndpoint() {
        return "/updates";
    }

    @Override
    public Map<String, Object> getQueryParams() {
        Map<String, Object> params = new HashMap<>();
        if (offset != null) {
            params.put("marker", offset);
        }
        if (timeout != null) {
            params.put("timeout", timeout);
        }
        return params;
    }

    @Override
    public TypeReference<GetUpdatesResponse> getResponseType() {
        return new TypeReference<>() {};
    }
}