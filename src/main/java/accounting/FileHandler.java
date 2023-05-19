package accounting;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FileHandler {

    private static final Logger log = Logger.getLogger(String.valueOf(FileHandler.class));

    public static ArrayList<Animal> getAnimalsFromFile(String filename) {
        ArrayList<Animal> animals = new ArrayList<>();

        log.info("Trying to open file with animals: " + filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                Animal newAnimal = new Animal(attributes[0].toUpperCase(), attributes[1].toUpperCase(), attributes[2].toUpperCase());
                animals.add(newAnimal);
            }
        } catch (IOException e) {
            log.warning("File " + filename + " not found");
            e.printStackTrace();
        }

        return animals;
    }

    public static ArrayList<Instruction> getInstructionsFromFile(String filename) {
        ArrayList<Instruction> listOfInstructions = new ArrayList<>();

        log.info("Trying to open file with instructions: " + filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Instruction rule;
            String line;

            List<Rule> ruleValues = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.toUpperCase().contains("ПРАВИЛО")) {
                    log.info("Adding new Instruction with name: " + line.split(":")[0]);
                    rule = new Instruction();
                    ruleValues = new ArrayList<>();
                    rule.setListOfRules(ruleValues);
                    rule.setInstructionName(line.split(":")[0].toUpperCase());
                    listOfInstructions.add(rule);
                }

                if (line.contains("=")) {
                    String[] splitString = line.trim().split("=");
                    Rule ruleValue = new Rule(splitString[0].toUpperCase(), splitString[1].toUpperCase());
                    ruleValues.add(ruleValue);
                }
            }
        } catch (IOException e) {
            log.warning("File " + filename + " not found");
            e.printStackTrace();
        }

        return listOfInstructions;
    }
}
