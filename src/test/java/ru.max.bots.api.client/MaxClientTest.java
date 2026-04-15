package ru.max.bots.api.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.max.bots.api.methods.GetMe;
import ru.max.bots.api.objects.BotInfo;

import java.nio.file.Files;
import java.nio.file.Paths;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

class MaxClientTest {

    private static WireMockServer wireMockServer;
    private static MaxClient client;

    @BeforeAll
    static void setUp() {
        // 1. Запускаем локальный фейковый сервер WireMock на случайном порту
        wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().dynamicPort());
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        // 2. Инициализируем нашего клиента
        // ВАЖНО: Мы передаем адрес локального сервера вместо реального API MAX
        String testBaseUrl = "http://localhost:" + wireMockServer.port();
        client = new MaxClient("test-token", testBaseUrl);
    }

    @AfterAll
    static void tearDown() {
        // Останавливаем сервер после выполнения всех тестов
        wireMockServer.stop();
    }

    @Test
    void testGetMeSuccess() throws Exception {
        // 1. Читаем наш JSON-файл с диска в строку
        String jsonBody = new String(Files.readAllBytes(Paths.get("src/test/resources/responses/get_me_success.json")));

        // 2. Настраиваем правило для WireMock:
        // "Если придет GET-запрос на /me с заголовком Authorization: test-token,
        // верни статус 200 и содержимое нашего JSON-файла"
        stubFor(get(urlEqualTo("/me"))
                .withHeader("Authorization", equalTo("test-token"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(jsonBody)));

        // 3. Вызываем метод, который мы тестируем
        BotInfo botInfo = client.execute(new GetMe());

        // 4. Проверяем, что Jackson правильно превратил JSON в Java-объект
        assertNotNull(botInfo);
        assertEquals(12345, botInfo.getUserId());
        assertEquals("Bot_Name", botInfo.getFirstName());
        assertEquals("example_bot", botInfo.getUsername());
        assertTrue(botInfo.getIsBot());
    }
}