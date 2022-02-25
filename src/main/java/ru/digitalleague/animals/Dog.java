package ru.digitalleague.animals;

public class Dog extends Animal {

    public Dog(String name) {
        super("[DOG]: " + name);
    }

    @Override
    protected String sound() {
        return "Гав";
    }
}
