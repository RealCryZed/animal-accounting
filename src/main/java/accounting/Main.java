package accounting;

import java.util.List;
import java.util.logging.Logger;

public class Main {

    private static final Logger log = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {
        List<Animal> animals = FileHandler.getAnimalsFromFile("dataset.txt");
        List<Instruction> instructions = FileHandler.getInstructionsFromFile("instructions.txt");

        AnimalsCounter animalsCounter = new AnimalsCounter(animals, instructions);
        animalsCounter.countAndPrint();
    }
}
