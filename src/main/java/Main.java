import ru.max.bots.api.client.MaxClient;
import ru.max.bots.api.exceptions.MaxApiException;
import ru.max.bots.api.methods.post.sendmessage.SendMessage;
import ru.max.bots.api.objects.newmessagebody.NewMessageBody;
import ru.max.bots.api.service.LongPollingService;

public class Main {
    public static void main(String[] args) {
        // 1. Создаем клиент с твоим токеном
        String realToken = System.getenv("BOT_MAX_TOKEN");
        MaxClient client = new MaxClient(realToken, "https://platform-api.max.ru/");

        // 2. Создаем сервис поллинга
        LongPollingService pollingService = new LongPollingService(client);

        // 3. Запускаем бота!
        pollingService.start(update -> {
            // Этот блок кода будет вызываться автоматически при КАЖДОМ новом сообщении!

            String text = update.getMessage().getBody().text();
            System.out.println("Новое сообщение от пользователя: " + text);

            // Если захочешь ответить, можешь сделать это прямо здесь:
            NewMessageBody body = NewMessageBody.builder()
                    .text("Проверка отправки по Chat ID! 🚀")
                    .build();

            long chatId = update.getMessage().getRecipient().chatId();
            SendMessage request = SendMessage.builder()
                    .chatId(chatId)
                    .body(body)
                    .build();

            try {
                client.execute(request);
            } catch (MaxApiException e) {
                throw new RuntimeException(e);
            }
        });
    }
}