package ru.max.bots.api.utils;

/**
 * Методы для обработки URL
 * @author DonBibon
 * @version 0.2
 */
public class UrlUtils {
    /**
     * Метод для отбрасывания / из URL
     * @param url форматируемый URL
     * @return отформатированный URL без /
     */
    public static String urlUnification(String url) {
        return url.endsWith("/") ? url.substring(0, url.length() - 1) : url;
    }
}
