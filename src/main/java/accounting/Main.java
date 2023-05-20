package accounting;

import accounting.functions.AnimalsCounter;
import accounting.functions.FileHandler;
import accounting.models.Animal;
import accounting.models.Instruction;

import java.util.List;


/**
 * Starter class. It gets animals and instructions lists from corresponding files, then creates object of AnimalCounter
 * and runs method to calculate animals. In the future we can add some functions in program without
 * changing the previous written code.
 */
public class Main {

    public static void main(String[] args) {
        List<Animal> animals = FileHandler.getAnimalsFromFile("dataset.txt");
        List<Instruction> instructions = FileHandler.getInstructionsFromFile("instructions.txt");

        AnimalsCounter animalsCounter = new AnimalsCounter(animals, instructions);
        animalsCounter.printCount();
    }
}
