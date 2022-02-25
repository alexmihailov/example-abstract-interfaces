package ru.digitalleague.messenger;

public interface DefaultOverrideMessenger extends Messenger {

    // Пример переопределения дефолтного метода в интерфейсе наследнике.
    default String messageWithClass(String message) {
        return Messenger.super.messageWithClass(message) + " new text";
    }

// Пример переопределения дефолтного метода в абстрактный метод
//    String messageWithClass(String message);
}
