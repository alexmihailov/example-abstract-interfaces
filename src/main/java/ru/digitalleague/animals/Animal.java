package ru.digitalleague.animals;

public abstract class Animal {

    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    protected abstract String sound();

    public String printSound() {
        return "Animal " + this.name + " " + this.sound();
    }
}
