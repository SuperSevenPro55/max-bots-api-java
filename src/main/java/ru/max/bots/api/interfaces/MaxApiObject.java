package ru.max.bots.api.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Базовый интерфейс для всех объектов MAX BOTS API
 * @author SuperSevenPro55
 * @version 0.1
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface MaxApiObject extends Serializable {
}
