package ru.max.bots.api.core;

import ru.max.bots.api.objects.update.Update;
import ru.max.bots.api.objects.update.bot.*;
import ru.max.bots.api.objects.update.chat.*;
import ru.max.bots.api.objects.update.dialog.*;
import ru.max.bots.api.objects.update.message.*;
import ru.max.bots.api.objects.update.user.*;

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