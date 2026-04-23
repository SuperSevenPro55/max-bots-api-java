package ru.max.bots.api.methods;

import okhttp3.Request;

/**
 * Базовый интерфейс для всех запросов к MAX API
 * @param <T> Тип объекта, возможный для получения в ответ
 * @author SuperSevenPro55
 * @version 0.1
 */

public interface MaxRequest<T> {
    /**
     * Метод собирает готовый запрос к серверу
     * @param baseUrl базовый адрес сервера
     * @param token токен бота
     * @return сформированный запрос
     */
    Request buildRequest(String baseUrl, String token);

    /**
     * Метод для получения класса ответа от сервера
     * @return класс ответа
     */
    Class<T> getResponseType();
}
