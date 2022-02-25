package ru.digitalleague.messenger;

import java.util.ArrayList;
import java.util.List;

public class MessengerImpl implements Messenger {

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
