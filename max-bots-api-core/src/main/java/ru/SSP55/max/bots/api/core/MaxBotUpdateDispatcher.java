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

public class MaxBotUpdateDispatcher {
    private final MaxBotUpdateListener listener;

    public MaxBotUpdateDispatcher(MaxBotUpdateListener listener) {
        this.listener = listener;
    }

    public void dispatch(Update update) {
        try {
            listener.onUpdate(update);

            switch (update) {
                case BotAddedUpdate added -> listener.onBotAdded(added);
                case BotStartedUpdate started -> listener.onBotStarted(started);
                case BotStoppedUpdate stopped -> listener.onBotStopped(stopped);
                case BotRemovedUpdate removed -> listener.onBotRemoved(removed);

                case ChatTitleChangedUpdate title -> listener.onChatTitleChanged(title);

                case DialogClearedUpdate cleared -> listener.onDialogCleared(cleared);
                case DialogMutedUpdate muted -> listener.onDialogMuted(muted);
                case DialogUnmutedUpdate unmuted -> listener.onDialogUnmuted(unmuted);
                case DialogRemovedUpdate removed -> listener.onDialogRemoved(removed);

                case MessageCreatedUpdate msg -> listener.onMessageCreated(msg);
                case MessageCallbackUpdate cb -> listener.onMessageCallback(cb);
                case MessageEditedUpdate edited -> listener.onMessageEdited(edited);
                case MessageRemovedUpdate removed -> listener.onMessageRemoved(removed);

                case UserAddedUpdate userAdded -> listener.onUserAdded(userAdded);
                case UserRemovedUpdate userRemoved -> listener.onUserRemoved(userRemoved);

                default -> {}
            }
        } catch (Exception e) {
            listener.onError(e);
        }
    }
}
