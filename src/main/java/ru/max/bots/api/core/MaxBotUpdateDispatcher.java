package ru.max.bots.api.core;

import ru.max.bots.api.objects.update.Update;
import ru.max.bots.api.objects.update.bot.*;
import ru.max.bots.api.objects.update.chat.*;
import ru.max.bots.api.objects.update.dialog.*;
import ru.max.bots.api.objects.update.message.*;
import ru.max.bots.api.objects.update.user.*;

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
