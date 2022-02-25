package ru.digitalleague.messenger;

public interface Messenger {

//     public static final String NO_MESSAGES_TEX = "There are currently no messages";
    String NO_MESSAGES_TEXT = "There are currently no messages";

//    public void endMessage(String message);
    void sendMessage(String message);

    String getMessage();

    default String messageWithClass(String message) {
        return createInternalMessage(message);
    }

//    static String messageWithClass(String message) {
//        return createInternalMessage(message);
//    }

//    private String createInternalMessage(String message);
    private String createInternalMessage(String message) {
        return "[" + this.getClass().getSimpleName() + "]: " + message;
    }
//    protected String createInternalMessage(String message) {
//    }
}
