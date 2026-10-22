package ru.SSP55.max.bots.api.core;

import ru.SSP55.max.bots.api.objects.update.Update;
import ru.SSP55.max.bots.api.objects.update.bot.BotAddedUpdate;
import ru.SSP55.max.bots.api.objects.update.bot.BotRemovedUpdate;
import ru.SSP55.max.bots.api.objects.update.bot.BotStartedUpdate;
import ru.SSP55.max.bots.api.objects.update.bot.BotStoppedUpdate;
import ru.SSP55.max.bots.api.objects.update.chat.ChatTitleChangedUpdate;
import ru.SSP55.max.bots.api.objects.update.dialog.DialogClearedUpdate;
import ru.SSP55.max.bots.api.objects.update.dialog.DialogMutedUpdate;
import ru.SSP55.max.bots.api.objects.update.dialog.DialogRemovedUpdate;
import ru.SSP55.max.bots.api.objects.update.dialog.DialogUnmutedUpdate;
import ru.SSP55.max.bots.api.objects.update.message.MessageCallbackUpdate;
import ru.SSP55.max.bots.api.objects.update.message.MessageCreatedUpdate;
import ru.SSP55.max.bots.api.objects.update.message.MessageEditedUpdate;
import ru.SSP55.max.bots.api.objects.update.message.MessageRemovedUpdate;
import ru.SSP55.max.bots.api.objects.update.user.UserAddedUpdate;
import ru.SSP55.max.bots.api.objects.update.user.UserRemovedUpdate;

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