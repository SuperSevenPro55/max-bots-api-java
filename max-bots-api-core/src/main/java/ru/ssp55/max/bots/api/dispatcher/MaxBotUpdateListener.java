package ru.ssp55.max.bots.api.dispatcher;

import ru.ssp55.max.bots.api.objects.update.Update;
import ru.ssp55.max.bots.api.objects.update.bot.BotAddedUpdate;
import ru.ssp55.max.bots.api.objects.update.bot.BotRemovedUpdate;
import ru.ssp55.max.bots.api.objects.update.bot.BotStartedUpdate;
import ru.ssp55.max.bots.api.objects.update.bot.BotStoppedUpdate;
import ru.ssp55.max.bots.api.objects.update.chat.ChatTitleChangedUpdate;
import ru.ssp55.max.bots.api.objects.update.dialog.DialogClearedUpdate;
import ru.ssp55.max.bots.api.objects.update.dialog.DialogMutedUpdate;
import ru.ssp55.max.bots.api.objects.update.dialog.DialogRemovedUpdate;
import ru.ssp55.max.bots.api.objects.update.dialog.DialogUnmutedUpdate;
import ru.ssp55.max.bots.api.objects.update.message.MessageCallbackUpdate;
import ru.ssp55.max.bots.api.objects.update.message.MessageCreatedUpdate;
import ru.ssp55.max.bots.api.objects.update.message.MessageEditedUpdate;
import ru.ssp55.max.bots.api.objects.update.message.MessageRemovedUpdate;
import ru.ssp55.max.bots.api.objects.update.user.UserAddedUpdate;
import ru.ssp55.max.bots.api.objects.update.user.UserRemovedUpdate;

public interface MaxBotUpdateListener {
    default void onUpdate(Update update) {}

    default void onBotAdded(BotAddedUpdate update) {}
    default void onBotStarted(BotStartedUpdate update) {}
    default void onBotStopped(BotStoppedUpdate update) {}
    default void onBotRemoved(BotRemovedUpdate update) {}

    default void onChatTitleChanged(ChatTitleChangedUpdate update) {}

    default void onDialogCleared(DialogClearedUpdate update) {}
    default void onDialogMuted(DialogMutedUpdate update) {}
    default void onDialogUnmuted(DialogUnmutedUpdate update) {}
    default void onDialogRemoved(DialogRemovedUpdate update) {}

    default void onMessageCreated(MessageCreatedUpdate update) {}
    default void onMessageCallback(MessageCallbackUpdate update) {}
    default void onMessageEdited(MessageEditedUpdate update) {}
    default void onMessageRemoved(MessageRemovedUpdate update) {}

    default void onUserAdded(UserAddedUpdate update) {}
    default void onUserRemoved(UserRemovedUpdate update) {}

    default void onError(Throwable throwable) {
        throwable.printStackTrace();
    }
}