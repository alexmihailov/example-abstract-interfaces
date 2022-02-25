package ru.digitalleague;

import ru.digitalleague.messenger.*;
import ru.digitalleague.messenger.multiple.MessengerV2;
import ru.digitalleague.messenger.multiple.MultipleMessengerImpl;

import java.util.*;
import java.util.function.*;

public class ExampleInterfaces {

    public static void main(String[] args) {
//        exampleMessenger();
        exampleMultipleImplementationMethod();
//        exampleCollectionsAndFunctionalInterfaces();
        // TODO рассмотреть основные интерфейсы в Java standard library
    }

    private static void exampleMessenger() {
        Messenger messenger = MessengerFactory.createMessenger();
        EncryptedMessenger encryptedMessenger = MessengerFactory.createEncryptedMessenger();
        TextFileSender fileSender = (TextFileSender) encryptedMessenger;
// Так как EncryptedMessengerImpl расширяет TextFileSender, то мы можем encryptedMessenger явно привести к TextFileSender.
// Но если messenger попробуем привести к TextFileSender, то получим cast exception.
// Показать вариант решения этой проблемы при помощи наследования интерфейсов.
//        TextFileSender fileSender = (TextFileSender) messenger;

// Показать возможность создания анонимного объекта из интерфейса.
//        Messenger anon = new Messenger()

        for (int i = 0; i < 5; ++i) {
            messenger.sendMessage("Message " + i);
// Так как EncryptedMessenger наследует Messenger, то можно использовать encryptedMessenger для отправки обычных сообщений
//            encryptedMessenger.sendMessage("Message " + i);
            encryptedMessenger.sendEncryptedMessage("Encrypted message " + i);
            fileSender.sendFile("File " + i);
        }
        for (int i = 0; i <= 5; ++i) {
            System.out.println(messenger.getMessage());
            System.out.println(encryptedMessenger.getEncryptedMessage());
// Так как EncryptedMessenger наследует Messenger, то можно использовать encryptedMessenger для приема обычных сообщений
//            System.out.println(encryptedMessenger.getMessage());
            System.out.println(fileSender.getFile());
        }
    }

    private static void exampleMultipleImplementationMethod() {
        MultipleMessengerImpl multipleMessengerImpl = new MultipleMessengerImpl();
        Messenger messenger = multipleMessengerImpl;
        MessengerV2 messengerV2 = multipleMessengerImpl;

        messenger.sendMessage("Test message from Messenger");
        messengerV2.sendMessage("Test message from MessengerV2");
        System.out.println(messenger.getMessage());
        System.out.println(messengerV2.getMessage());
    }

    private static void exampleCollectionsAndFunctionalInterfaces() {
        // Показать java.util.List и его реализации
        List<Integer> values = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; ++i) {
            values.add(random.nextInt(100));
        }
        // Метод sort является дефолтным, так как был добавлен в 8 версии.
        // На вход принимаем java.util.Comparator и тут рассказать про функциональные интерфейсы.
        values.sort(Comparator.comparingInt(o -> o));
        System.out.println(Arrays.toString(values.toArray()));

        // Наиболее популярные функциональные интерфейсы
        // Показать, что можно лямбду заменить на анонимный объект или ссылку на метод
        Function<Integer, String> toSting = value -> value.toString();
        System.out.println(toSting.apply(5));

        Predicate<Object> isNotNull = obj -> obj != null;
        System.out.println(isNotNull.test(System.in));

        UnaryOperator<Integer> sqrt = value -> value * value;
        System.out.println(sqrt.apply(5));

        BinaryOperator<Integer> plus = (val1, val2) -> val1 + val2;
        System.out.println(plus.apply(15, 5));

        Supplier<Integer> randomInt = () -> random.nextInt();
        System.out.println(randomInt.get());

        Consumer<String> consumer = value -> System.out.println(value);
        consumer.accept("Hello, Consumer");
    }


}
