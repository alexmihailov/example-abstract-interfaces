package ru.digitalleague.messenger;

public final class MessengerFactory {

    private MessengerFactory() {
        // nothing
    }

    public static Messenger createMessenger() {
        return new MessengerImpl();
    }

    public static EncryptedMessenger createEncryptedMessenger() {
        return new EncryptedMessengerImpl();
    }
}
