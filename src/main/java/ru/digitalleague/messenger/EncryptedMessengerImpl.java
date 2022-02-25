package ru.digitalleague.messenger;

import java.util.ArrayList;
import java.util.List;

public class EncryptedMessengerImpl extends MessengerImpl implements EncryptedMessenger, TextFileSender {

    private final List<String> decryptedMessages = new ArrayList<>();
    private final List<String> files = new ArrayList<>();

    @Override
    public void sendEncryptedMessage(String message) {
//        decryptedMessages.add(encryptMessage(messageWithClass(message)));
        decryptedMessages.add(EncryptedMessenger.encryptMessage(messageWithClass(message)));
    }

    @Override
    public String getEncryptedMessage() {
        if (decryptedMessages.isEmpty()) {
            return messageWithClass(NO_MESSAGES_TEXT);
        } else {
            String message = decryptedMessages.get(decryptedMessages.size() - 1);
            decryptedMessages.remove(decryptedMessages.size() - 1);
            return EncryptedMessenger.decryptMessage(message);
        }
    }

    @Override
    public void sendFile(String content) {
        files.add(content);
    }

    @Override
    public String getFile() {
        if (files.isEmpty()) {
            return NO_FILES;
        } else {
            String file = files.get(files.size() - 1);
            files.remove(files.size() - 1);
            return file;
        }
    }
}
