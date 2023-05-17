package accounting;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Main {

    private static final Logger log = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {
        ArrayList<Animal> animals = FileHandler.getAnimalsFromFile("dataset.txt");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
