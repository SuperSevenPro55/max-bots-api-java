package ru.max.bots.api.exceptions;

/**
 * Базовый класс для всех исключений MAX BOTS API
 * @author SuperSevenPro55
 * @version 0.1
 */

public class MaxApiException extends Exception {
    public MaxApiException() {
        super();
    }

    public MaxApiException(String message) {
        super(message);
    }

    public MaxApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaxApiException(Throwable cause) {
        super(cause);
    }

    protected MaxApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
