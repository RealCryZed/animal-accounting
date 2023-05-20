package accounting;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class has 2 main functions for working with files needed for proper work.
 */
public class FileHandler {

    private static final Logger log = Logger.getLogger(String.valueOf(FileHandler.class));

    /**
     * Method opens file using filename field, then reads it line by line and creates animals, by splitting the line
     * by ',' character.
     * @param filename path to the file with animals
     * @return ArrayList of created animals
     */
    public static ArrayList<Animal> getAnimalsFromFile(String filename) {
        ArrayList<Animal> animals = new ArrayList<>();

        log.info("Trying to open file with Animals: " + filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                Animal newAnimal = new Animal(attributes[0], attributes[1], attributes[2]);
                animals.add(newAnimal);
            }
        } catch (IOException e) {
            log.warning("File " + filename + " not found");
            e.printStackTrace();
        }

        return animals;
    }

    /**
     * Method opens file using filename field, creates List of Rules,
     * then reads the file line by line and creates objects Instruction and Rule.
     * These object then will be added to listOfInstructions and listOfRules accordingly.
     * @param filename path to the file with instructions
     * @return ArrayList with instructions
     */
    public static ArrayList<Instruction> getInstructionsFromFile(String filename) {
        ArrayList<Instruction> listOfInstructions = new ArrayList<>();

        log.info("Trying to open file with Instructions: " + filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Instruction instruction;
            String line;

            List<Rule> listOfRules = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.contains("ПРАВИЛО")) {
                    instruction = new Instruction();
                    listOfRules = new ArrayList<>();
                    instruction.setListOfRules(listOfRules);
                    instruction.setInstructionName(line.split(":")[0]);
                    listOfInstructions.add(instruction);
                }

                if (line.contains("=")) {
                    String[] splitString = line.trim().split("=");
                    Rule rule = new Rule(splitString[0], splitString[1]);
                    listOfRules.add(rule);
                }
            }
        } catch (IOException e) {
            log.warning("File " + filename + " not found");
            e.printStackTrace();
        }

        return listOfInstructions;
    }
}
