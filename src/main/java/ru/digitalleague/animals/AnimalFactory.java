package ru.digitalleague.animals;

import java.util.Arrays;

public final class AnimalFactory {

    private AnimalFactory() {
        // nothing
    }

    public static Animal getAnimal(AnimalType type, String name) throws UnknownAnimalException {
        Animal result;
        switch (type) {
            case CAT:
                result = new Cat(name);
                break;
            case COW:
                result = new Cow(name);
                break;
            case DOG:
                result = new Dog(name);
                break;
// Пример, когда для утку добавили в enum, но switch не изменили.
//            case DUCK:
//                result = new Duck(name);
//                break;
            default:
                throw new UnknownAnimalException(type);
// Пример с созданием анонимного объекта на основе абстрактного класса (нужно раскоментить строку ru/digitalleague/ExampleAbstract.java:17)
//            default:
//                result = new Animal(name) {
//                    @Override
//                    protected String sound() {
//                        return "unknown";
//                    }
//                };
        }
        return result;
    }

    public enum AnimalType {
        CAT(1), COW(2), DOG(3), DUCK(4), UNKNOWN(-1);

        private final int code;

        AnimalType(int code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return "AnimalType{" +
                    "code=" + code +
                    '}';
        }

        public static AnimalType fromCode(int code) {
            return Arrays.stream(values()).filter(it -> it.code == code).findFirst().orElse(UNKNOWN);
        }
    }

    public static class UnknownAnimalException extends Exception {
        public UnknownAnimalException(AnimalType type) {
            super("Unknown type of animal: " + type);
        }
    }
}
