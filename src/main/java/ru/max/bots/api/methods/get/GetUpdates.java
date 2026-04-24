package ru.max.bots.api.methods.get;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import okhttp3.HttpUrl;
import okhttp3.Request;
import ru.max.bots.api.methods.MaxRequest;
import ru.max.bots.api.objects.Update;

import java.util.Objects;

@Builder
public class GetUpdates implements MaxRequest<GetUpdatesResponse> {

    private final Long offset;
    private final Integer timeout;

    @Override
    public Request buildRequest(String baseUrl, String token, ObjectMapper objectMapper) {
        // UrlUtils подхватит baseUrl и приклеит getUpdates без ошибок со слэшами
        String fullUrl = baseUrl + "/updates";

        // Для добавления ?offset=... используем штатный HttpUrl из OkHttp
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(fullUrl)).newBuilder();

        if (offset != null) urlBuilder.addQueryParameter("offset", String.valueOf(offset));
        if (timeout != null) urlBuilder.addQueryParameter("timeout", String.valueOf(timeout));

        return new Request.Builder()
                .url(urlBuilder.build())
                .get()
                .header("Authorization", token)
                .build();
    }

    @Override

    public Class<GetUpdatesResponse> getResponseType() {
        return GetUpdatesResponse.class;
    }
}