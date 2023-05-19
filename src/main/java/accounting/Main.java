package accounting;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Animal> animals = FileHandler.getAnimalsFromFile("dataset.txt");
        List<Instruction> instructions = FileHandler.getInstructionsFromFile("instructions.txt");

        AnimalsCounter animalsCounter = new AnimalsCounter(animals, instructions);
        animalsCounter.countAndPrint();
    }
}
