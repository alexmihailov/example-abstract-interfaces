package ru.digitalleague.animals;

public class Cat extends Animal {

    public Cat(String name) {
        super("[CAT]: " + name);
    }

    @Override
    protected String sound() {
        return "Мяу";
    }
}
