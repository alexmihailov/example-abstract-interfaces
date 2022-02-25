package ru.digitalleague.messenger;

public interface TextFileSender {

    String NO_FILES = "No files";

    void sendFile(String content);

    String getFile();
}
