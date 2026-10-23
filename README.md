# MAX Bots API Java SDK

Современная модульная Java-библиотека для создания ботов в мессенджере **MAX** ([официальная документация API](https://dev.max.ru/docs-api)).  
Построена на базе **Java 21** (нативный `HttpClient`, `record`, Pattern Matching), **Jackson 3** и поддерживает автоконфигурацию для **Spring Boot 4**.

---

## 📦 Архитектура и модули

Проект разделен на независимые модули, чтобы вы могли подключать только нужную функциональность:

| Модуль                                 | Описание                                                                                                                                     |
|:---------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------|
| **`max-bots-api-core`**                | Ядро библиотеки: HTTP-клиент (`MaxClient`), методы API, DTO-модели и диспетчер событий (`MaxBotUpdateDispatcher`). Не зависит от Spring.     |
| **`max-bots-api-longpolling`**         | Фоновый сервис получения событий через Long Polling (`GET /updates`).                                                                        |
| **`max-bots-api-webhook`**             | Сервис обработки входящих событий через WebHooks *(в разработке)*.                                                                           |
| **`max-bots-api-spring-boot-starter`** | Готовый стартер для Spring Boot: автоматически поднимает `MaxClient` и связывает ваш `MaxBotUpdateListener` с сервисом получения обновлений. |

---

## 🚀 Подключение к проекту

Пакеты опубликованы в **GitHub Packages**. Добавьте репозиторий в ваш `pom.xml`:

```xml
<repositories>
    <repository>
        <id>github</id>
        <url>[https://maven.pkg.github.com/supersevenpro55/max-bots-api-java](https://maven.pkg.github.com/supersevenpro55/max-bots-api-java)</url>
    </repository>
</repositories>