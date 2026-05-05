package ru.max.bots.api.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.max.bots.api.exceptions.MaxApiException;
import ru.max.bots.api.methods.get.GetMe;
import ru.max.bots.api.methods.post.sendmessage.SendMessage;
import ru.max.bots.api.methods.post.sendmessage.SendMessageResponse;
import ru.max.bots.api.objects.message.Message;
import ru.max.bots.api.objects.newmessagebody.NewMessageBody;
import ru.max.bots.api.objects.newmessagebody.attachments.AttachmentRequest;
import ru.max.bots.api.objects.newmessagebody.attachments.buttons.CallbackButtonRequest;
import ru.max.bots.api.objects.newmessagebody.attachments.buttons.LinkButtonRequest;
import ru.max.bots.api.objects.newmessagebody.attachments.buttons.MessageButtonRequest;
import ru.max.bots.api.objects.newmessagebody.attachments.payloads.InlineKeyboardAttachmentRequestPayload;
import ru.max.bots.api.objects.user.BotInfo;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

class MaxClientTest {

    private static WireMockServer wireMockServer;
    private static MaxClient client;

    @BeforeAll
    static void setUp() {
        wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().dynamicPort());
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        String testBaseUrl = "http://localhost:" + wireMockServer.port();
        client = new MaxClient("test-token", testBaseUrl);
    }

    @AfterAll
    static void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void testGetMeSuccess() throws Exception {
        // ЭЛЕГАНТНЫЙ WIREMOCK:
        // Используем .withBodyFile(), WireMock сам найдет файл в папке __files
        stubFor(get(urlEqualTo("/me"))
                .withHeader("Authorization", equalTo("test-token"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("get_me_success.json")));

        BotInfo botInfo = client.execute(new GetMe());

        // 1. Проверяем базовые поля (учитываем, что user_id может быть Long)
        assertNotNull(botInfo);
        assertEquals(12345L, botInfo.getUserId());
        assertEquals("Bot_Name", botInfo.getFirstName());
        assertEquals("example_bot", botInfo.getUsername());
        assertTrue(botInfo.getIsBot());
        assertEquals(1739184000000L, botInfo.getLastActivityTime());

        // 2. Проверяем новые поля, специфичные для BotInfo
        assertNotNull(botInfo.getDescription());
        assertTrue(botInfo.getDescription().startsWith("🚀 Автовыдача"));
        assertEquals("https://i.oneme.ru/i?r=BTFjO43w8Yr1OSJ4tcurq5HiGFXTgmcNFCqWsL5eFLaBsq_WO3gNo_PCmzpboct_jy8", botInfo.getAvatarUrl());
        assertEquals("https://i.oneme.ru/i?r=BTFjO43w8Yr1OSJ4tcurq5HiHBeIhpWE6pyKskhnmJMdXK_WO3gNo_PCmzpboct_jy8", botInfo.getFullAvatarUrl());

        // 3. Проверяем десериализацию массива команд
        assertNotNull(botInfo.getCommands());
        assertEquals(2, botInfo.getCommands().size());

        // В record поля вызываются как методы без get: name() вместо getName()
        assertEquals("start", botInfo.getCommands().get(0).name());
        assertEquals("Главное меню", botInfo.getCommands().get(0).description());

        assertEquals("help", botInfo.getCommands().get(1).name());
    }

    @Test
    void testRealGetMe() throws Exception {
        String realToken = System.getenv("BOT_MAX_TOKEN");

        String baseUrl = "https://platform-api.max.ru/";

        MaxClient client = new MaxClient(realToken, baseUrl);

        BotInfo botInfo = client.execute(new GetMe());

        System.out.println("Подключено к боту: " + botInfo.getFirstName());
        System.out.println("Username: @" + botInfo.getUsername());
        System.out.println("ID: " + botInfo.getUserId());

        // 5. Базовые проверки
        assertNotNull(botInfo);
        assertTrue(botInfo.getIsBot());
        assertNotNull(botInfo.getUsername());
    }

    @Test
    void testRealSendMessageByChatId() throws Exception {
        // 1. Инициализация (токен берем из переменных окружения для безопасности)
        String realToken = System.getenv("BOT_MAX_TOKEN");
        String baseUrl = "https://platform-api.max.ru/";
        MaxClient client = new MaxClient(realToken, baseUrl);

        // 2. Твой реальный ID чата
        Long targetChatId = 390388082L;

        // 3. Тело сообщения
        NewMessageBody body = NewMessageBody.builder()
                .text("Проверка отправки по Chat ID! 🚀")
                .build();

        // 4. Сборка запроса. Используем .chatId() вместо .userId()
        SendMessage request = SendMessage.builder()
                .chatId(targetChatId)
                .body(body)
                .build();

        System.out.println("Отправка сообщения в чат " + targetChatId + "...");

        try {
            SendMessageResponse response = client.execute(request);

            Message sentMessage = response.getMessage();

            System.out.println("✅ Успешно! ID сообщения: " + sentMessage.getBody().mid());
            assertNotNull(sentMessage);
        } catch (MaxApiException e) {
            System.err.println("❌ Ошибка API: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void testRealSendMessageWithKeyboard() throws Exception {
        String realToken = System.getenv("BOT_MAX_TOKEN");
        String baseUrl = "https://platform-api.max.ru/";
        MaxClient client = new MaxClient(realToken, baseUrl);

        Long targetChatId = 390388082L; // Твой ID чата

        // 1. Создаем кнопки (Jackson сам добавит им поле "type" благодаря интерфейсу InlineButtonRequest)
        var btn1 = new LinkButtonRequest("🌐 Наш сайт", "https://example.com");
        var btn2 = new CallbackButtonRequest("✅ Подтвердить", "confirm_action_123");
        var btn3 = new MessageButtonRequest("Кнопка с текстом");

        // 2. Собираем клавиатуру (один ряд с двумя кнопками)
        var keyboardPayload = new InlineKeyboardAttachmentRequestPayload(
                List.of(List.of(btn1, btn2), List.of(btn3, btn3, btn3, btn3))
        );

        // 3. Собираем Вложение
        var keyboardAttachment = new AttachmentRequest("inline_keyboard", keyboardPayload);

        // 4. Пакуем всё в тело сообщения
        NewMessageBody body = NewMessageBody.builder()
                .text("Привет! Вот моя первая клавиатура из Java SDK 🚀")
                .attachments(List.of(keyboardAttachment))
                .build();

        // 5. Отправляем запрос
        SendMessage request = SendMessage.builder()
                .chatId(targetChatId)
                .body(body)
                .build();

        System.out.println("Отправка сообщения с клавиатурой...");
        var response = client.execute(request);

        assertNotNull(response);
        System.out.println("✅ Успех! ID сообщения: " + response.getMessage().getBody());
    }
}