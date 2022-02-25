package ru.digitalleague.messenger;

import java.util.Base64;

public interface EncryptedMessenger extends Messenger {

    void sendEncryptedMessage(String message);

    String getEncryptedMessage();

    static String encryptMessage(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    static String decryptMessage(String message) {
        return new String(Base64.getDecoder().decode(message));
    }
}
