package ru.digitalleague;

import ru.digitalleague.animals.Animal;
import ru.digitalleague.animals.AnimalFactory;

import static ru.digitalleague.animals.AnimalFactory.AnimalType.fromCode;
import static ru.digitalleague.animals.AnimalFactory.getAnimal;

public class ExampleAbstract {

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            AnimalFactory.AnimalType type = fromCode(i);
            try {
                Animal animal = getAnimal(type, "Name" + i);
                System.out.println(animal.printSound());
            } catch (AnimalFactory.UnknownAnimalException e) {
                System.out.println("Can't create animal. " + e.getMessage());
            }
        }
    }
}
