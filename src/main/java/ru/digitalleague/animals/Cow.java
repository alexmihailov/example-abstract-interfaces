package ru.digitalleague.animals;

public class Cow extends Animal {

    public Cow(String name) {
        super("[COW]: " + name);
    }

    @Override
    protected String sound() {
        return "Му";
    }
}
