package accounting;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    private static final Logger log = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Легкое", "Маленькое", "Всеядное"));
        animals.add(new Animal("Среднее", "Маленькое", "Всеядное"));
        animals.add(new Animal("Тяжелое", "Маленькое", "Всеядное"));
        animals.add(new Animal("Тяжелое", "Маленькое", "Травоядное"));
        animals.add(new Animal("Тяжелое", "Невысокое", "Всеядное"));
        animals.add(new Animal("Тяжелое", "Невысокое", "Травоядное"));
    }
}
