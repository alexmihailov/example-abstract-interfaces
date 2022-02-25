package ru.digitalleague.messenger;

public interface Messenger {

// При объявлении констант в интерфейсе можно опускать public static final
//     public static final String NO_MESSAGES_TEX = "There are currently no messages";
    String NO_MESSAGES_TEXT = "There are currently no messages";

// При объявлении абстрактных методов можно опускать public
//    public void endMessage(String message);
    void sendMessage(String message);

    String getMessage();

    // Пример дефолтного метода, который использует закрытый метод интерфейса
    default String messageWithClass(String message) {
        return createInternalMessage(message);
    }

// Начиная с Java 9 в интерфейсах можно описывать закрытые методы, но они должны иметь тело.
//    private String createInternalMessage(String message);
    private String createInternalMessage(String message) {
        return "[" + this.getClass().getSimpleName() + "]: " + message;
    }

// Нельзя в интерфейсе объявлять protected методы
//    protected String createInternalMessage(String message) {
//    }

// Пример с добавление в существующий интерфейс нового функционала (одно из применений default)
// Показать и рассказать про вариант добавление нового функционала путем расширения интерфейса (по сути EncryptedMessenger).
//    String newMethod();
//    default String newMethodAsDefault() {
//        return "default realization";
//    }
}
