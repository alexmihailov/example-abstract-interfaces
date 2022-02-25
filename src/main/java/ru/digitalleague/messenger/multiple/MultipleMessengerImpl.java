package ru.digitalleague.messenger.multiple;

import ru.digitalleague.messenger.Messenger;

import java.util.ArrayList;
import java.util.List;

// Пример реализации интерфейсов с одинаковыми методами.
public class MultipleMessengerImpl implements Messenger, MessengerV2 {

    private final List<String> messages = new ArrayList<>();

    @Override
    public void sendMessage(String message) {
        messages.add(messageWithClass(message));
    }

    @Override
    public String getMessage() {
        if (messages.isEmpty()) {
            return messageWithClass(NO_MESSAGES_TEXT);
        } else {
            String message = messages.get(messages.size() - 1);
            messages.remove(messages.size() - 1);
            return message;
        }
    }
}
