package ru.digitalleague.animals;

public class Duck extends Animal {

    public Duck(String name) {
        super("[DUCK]: " + name);
    }

    @Override
    protected String sound() {
        return "Кря";
    }
}
