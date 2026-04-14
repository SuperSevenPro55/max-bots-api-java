package ru.max.bots.api.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.max.bots.api.exceptions.MaxApiException;
import ru.max.bots.api.interfaces.MaxRequest;

import java.io.IOException;

/**
 * Клиент для отправки запросов к MAX API
 * @author SuperSevenPro55
 * @version 0.1
 */

public class MaxClient {
    private final String botToken;
    private final String baseUrl;
    private final OkHttpClient client;
    private final ObjectMapper mapper;

    /**
     * Конструктор клиента для отправки запросов к MAX API
     * @param botToken токен бота
     * @param baseUrl базовый адрес сервера
     */
    public MaxClient(String botToken, String baseUrl) {
        this.botToken = botToken;
        this.baseUrl = baseUrl;
        this.client = new OkHttpClient();
        this.mapper = new ObjectMapper();
    }


    /**
     * Универсальный метод для выполнения любого запроса к MAX API.
     * <p>
     * Отправляет сформированный HTTP-запрос на сервер, обрабатывает базовые ошибки сети
     * и статусы ответов, после чего десериализует JSON-ответ в соответствующий Java-объект.
     *
     * @param request объект запроса, содержащий логику сборки параметров и URL
     * @param <T>     тип ожидаемого объекта в ответе
     * @return готовый Java-объект с данными от сервера
     * @throws MaxApiException если произошла ошибка сети, сервер вернул ошибку (HTTP код отличный от 2xx)
     * или если тело ответа оказалось пустым
     */
    public <T> T execute(MaxRequest<T> request) throws MaxApiException {
        Request okRequest = request.buildRequest(baseUrl, botToken);

        try (Response response = client.newCall(okRequest).execute()) {
            if (!response.isSuccessful()) {
                throw new MaxApiException("Ошибка MAX API. HTTP статус: " + response.code());
            }

            if (response.body() == null) {
                throw new MaxApiException("Тело ответа пустое");
            }

            return mapper.readValue(response.body().string(), request.getResponseType());
        } catch (IOException e) {
            throw new MaxApiException("Ошибка сети при выполнении запроса", e);
        }
    }
}
