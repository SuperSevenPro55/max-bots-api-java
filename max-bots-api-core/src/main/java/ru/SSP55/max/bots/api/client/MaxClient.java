package ru.SSP55.max.bots.api.client;

import ru.SSP55.max.bots.api.exceptions.MaxApiException;
import ru.SSP55.max.bots.api.methods.MaxRequest;
import ru.SSP55.max.bots.api.utils.UrlUtils;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Основной клиент для взаимодействия с MAX API
 * @author SuperSevenPro55
 * @version 0.2
 */
public class MaxClient {
    private static final String DEFAULT_BASE_URL = "https://platform-api.max.ru";

    private final String botToken;
    private final String baseUrl;
    private final HttpClient client;
    private final ObjectMapper mapper;

    public MaxClient(String botToken) {
        this(botToken, DEFAULT_BASE_URL);
    }

    public MaxClient(String botToken, String url) {
        this.botToken = botToken;
        this.baseUrl = UrlUtils.urlUnification(url);
        this.client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        this.mapper = JsonMapper.builder().build();
    }

    public <T> T execute(MaxRequest<T> request) throws MaxApiException {
        try {
            URI uri = buildUri(request.getEndpoint(), request.getQueryParams());

            HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .uri(uri)
                    .timeout(Duration.ofSeconds(60))
                    .header("Authorization", botToken);

            HttpRequest.BodyPublisher bodyPublisher;
            if (request.getBody() != null) {
                String jsonBody = mapper.writeValueAsString(request.getBody());
                bodyPublisher = HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8);
                requestBuilder.header("Content-Type", "application/json; charset=utf-8");
            } else {
                bodyPublisher = HttpRequest.BodyPublishers.noBody();
            }

            requestBuilder.method(request.getMethod().name(), bodyPublisher);

            HttpResponse<String> response = client.send(
                    requestBuilder.build(),
                    HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)
            );

            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                throw new MaxApiException("Ошибка при обращении к MAX API. Код ответа: "
                        + response.statusCode() + ", тело: " + response.body());
            }

            return mapper.readValue(response.body(), request.getResponseType());
        } catch (JacksonException e) {
            throw new MaxApiException("Ошибка парсинга JSON при работе с MAX API", e);
        } catch (IOException e) {
            throw new MaxApiException("Сетевая ошибка при обращении к MAX API", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new MaxApiException("Запрос к MAX API был прерван", e);
        }
    }

    private URI buildUri(String endpoint, Map<String, Object> queryParams) {
        String cleanEndpoint = endpoint.startsWith("/") ? endpoint : "/" + endpoint;
        StringBuilder urlBuilder = new StringBuilder(baseUrl).append(cleanEndpoint);

        if (queryParams != null && !queryParams.isEmpty()) {
            String query = queryParams.entrySet().stream()
                    .filter(entry -> entry.getValue() != null)
                    .map(entry -> URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8) + "="
                            + URLEncoder.encode(String.valueOf(entry.getValue()), StandardCharsets.UTF_8))
                    .collect(Collectors.joining("&"));

            if (!query.isEmpty()) {
                urlBuilder.append("?").append(query);
            }
        }
        return URI.create(urlBuilder.toString());
    }
}