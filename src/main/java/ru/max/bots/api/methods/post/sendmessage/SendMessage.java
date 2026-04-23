package ru.max.bots.api.methods.post.sendmessage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import ru.max.bots.api.methods.MaxRequest;
import ru.max.bots.api.objects.newmessagebody.NewMessageBody;
import okhttp3.*;

import java.util.Objects;

@Builder
public class SendMessage implements MaxRequest<SendMessageResponse> {
    private final Long userId;
    private final Long chatId;
    private final Boolean disableLinkPreview;
    private final NewMessageBody body;



    @Override
    public Request buildRequest(String baseUrl, String botToken, ObjectMapper objectMapper) {
        // 1. Формируем URL с Query-параметрами
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(baseUrl + "/messages")).newBuilder();

        if (userId != null) urlBuilder.addQueryParameter("user_id", String.valueOf(userId));
        if (chatId != null) urlBuilder.addQueryParameter("chat_id", String.valueOf(chatId));
        if (disableLinkPreview != null) {
            urlBuilder.addQueryParameter("disable_link_preview", String.valueOf(disableLinkPreview));
        }

        String url = urlBuilder.build().toString();

        try {
            // 2. Сериализуем тело запроса
            String jsonBody = objectMapper.writeValueAsString(body);
            RequestBody okBody = RequestBody.create(
                    jsonBody,
                    MediaType.parse("application/json; charset=utf-8")
            );

            // 3. Собираем финальный запрос
            return new Request.Builder()
                    .url(url)
                    .header("Authorization", botToken)
                    .post(okBody)
                    .build();

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка при сборке JSON для SendMessage", e);
        }
    }

    @Override
    public Class<SendMessageResponse> getResponseType() {
        return SendMessageResponse.class;
    }
}
