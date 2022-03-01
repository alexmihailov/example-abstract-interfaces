package ru.digitalleague;

import ru.digitalleague.animals.*;
import ru.digitalleague.messenger.*;

import static ru.digitalleague.animals.AnimalFactory.getAnimal;

public class ExampleInstanceof {

    public static void main(String[] args) throws AnimalFactory.UnknownAnimalException {
        exampleClasses();
        exampleInterfaces();
    }

    private static void exampleClasses() throws AnimalFactory.UnknownAnimalException {
        Animal cat = getAnimal(AnimalFactory.AnimalType.CAT, "Васька");
        Animal dog = getAnimal(AnimalFactory.AnimalType.DOG, "Барбос");
        Animal cow = getAnimal(AnimalFactory.AnimalType.COW, "Машка");
        Animal anon = new Animal("Anon") {
            @Override
            protected String sound() {
                return "anon";
            }
        };

        System.out.println("cat instanceof Cat: " + (cat instanceof Cat));
        System.out.println("dog instanceof Dog: " + (dog instanceof Dog));
        System.out.println("cow instanceof Cow: " + (cow instanceof Cow));
        System.out.println();

        System.out.println("cat instanceof Animal: " + (cat instanceof Animal));
        System.out.println("dog instanceof Animal: " + (dog instanceof Animal));
        System.out.println("cow instanceof Animal: " + (cow instanceof Animal));
        System.out.println("anon instanceof Animal: " + (anon instanceof Animal));
        System.out.println();

        System.out.println("cat instanceof Dog: " + (cat instanceof Dog));
        System.out.println("dog instanceof Cat: " + (dog instanceof Cat));
        System.out.println("cow instanceof Duck: " + (cow instanceof Duck));

        if (cat instanceof Cat) {
            Cat catV2 = (Cat) cat;
            System.out.println(catV2.printSound());
        }

        if (cow instanceof Dog) {
            Dog dogV2 = (Dog) cow;
            dogV2.printSound();
        }
// Пример того, что без проверки можно получить ClassCastException
//        Dog dogV2 = (Dog) cow;
//        dogV2.printSound();
    }

    private static void exampleInterfaces() {
        Messenger messengerV1 = MessengerFactory.createMessenger();
        Messenger messengerV2 = MessengerFactory.createEncryptedMessenger();

        System.out.println("messengerV1 instanceof MessengerImpl: " + (messengerV1 instanceof MessengerImpl));
        System.out.println("messengerV2 instanceof EncryptedMessenger: " + (messengerV2 instanceof EncryptedMessenger));
        System.out.println("messengerV2 instanceof TextFileSender: " + (messengerV2 instanceof TextFileSender));
        System.out.println("messengerV2 instanceof MessengerImpl: " + (messengerV2 instanceof MessengerImpl));
        System.out.println("messengerV2 instanceof EncryptedMessengerImpl: " + (messengerV2 instanceof EncryptedMessengerImpl));
        System.out.println();

        if (messengerV2 instanceof EncryptedMessenger) {
            EncryptedMessenger encryptedMessenger = (EncryptedMessenger) messengerV2;
            encryptedMessenger.sendEncryptedMessage("Test Encrypted");
            System.out.println(encryptedMessenger.getEncryptedMessage());
        }

        if (messengerV1 instanceof TextFileSender) {
            TextFileSender fileSender = (TextFileSender) messengerV1;
            fileSender.sendFile("test send file");
            System.out.println(fileSender.getFile());
        }
// Пример того, что без проверки можно получить ClassCastException
//        TextFileSender fileSender = (TextFileSender) messengerV1;
//        fileSender.sendFile("test send file");
//        System.out.println(fileSender.getFile());
    }
}
