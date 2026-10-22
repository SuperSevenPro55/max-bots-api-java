package ru.SSP55.max.bots.api.methods;

import tools.jackson.core.type.TypeReference;
import java.util.Collections;
import java.util.Map;

/**
 * Базовый интерфейс для всех запросов к MAX API
 * @param <T> Тип ожидаемого ответа
 * @author SuperSevenPro55
 * @version 0.2
 */
public interface MaxRequest<T> {
    HttpMethod getMethod();
    String getEndpoint();
    TypeReference<T> getResponseType();

    default Map<String, Object> getQueryParams() {
        return Collections.emptyMap();
    }

    default Object getBody() {
        return null;
    }
}