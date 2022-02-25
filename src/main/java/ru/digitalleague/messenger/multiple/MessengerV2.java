package ru.digitalleague.messenger.multiple;

public interface MessengerV2 {

    void sendMessage(String message);
// Если два интерфейса имеют одинаковые методы, но разные возвращаемые типы, то будет ошибка компиляции (показать пример!)
//    boolean sendMessage(String message);

    String getMessage();
}
