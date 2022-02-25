package ru.digitalleague;

import ru.digitalleague.messenger.*;

public class ExampleInterfaces {

    public static void main(String[] args) {
        Messenger messenger = MessengerFactory.createMessenger();
        EncryptedMessenger encryptedMessenger = MessengerFactory.createEncryptedMessenger();
        TextFileSender fileSender = (TextFileSender) encryptedMessenger;
//        TextFileSender fileSender = (TextFileSender) messenger;
//        Messenger anon = new Messenger()

        for (int i = 0; i < 5; ++i) {
            messenger.sendMessage("Message " + i);
//            encryptedMessenger.sendMessage("Message " + i);
            encryptedMessenger.sendEncryptedMessage("Encrypted message " + i);
            fileSender.sendFile("File " + i);
        }
        for (int i = 0; i <= 5; ++i) {
            System.out.println(messenger.getMessage());
            System.out.println(encryptedMessenger.getEncryptedMessage());
//            System.out.println(encryptedMessenger.getMessage());
            System.out.println(fileSender.getFile());
        }
    }
}
