package accounting;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class FileHandler {

    private static final Logger log = Logger.getLogger(String.valueOf(FileHandler.class));

    public static ArrayList<Animal> getAnimalsFromFile(String filename) {
        ArrayList<Animal> animals = new ArrayList<>();

        log.info("trying to open file with animals" + filename);
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

    public static ArrayList<Rule> getInstructionsFromFile(String filename) {
        ArrayList<Rule> listOfInstructions = new ArrayList<>();

        log.info("trying to open file with animals" + filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Rule rule;
            String line;

            List<RuleValue> ruleValues = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.contains("ПРАВИЛО")) {
                    log.info("Adding new Rule from the file with name: " + line.split(":")[0]);
                    rule = new Rule();
                    ruleValues = new ArrayList<>();
                    rule.setListOfRules(ruleValues);
                    rule.setRuleName(line.split(":")[0]);
                    listOfInstructions.add(rule);
                }

                if (line.contains("=")) {
                    String[] splitString = line.trim().split("=");
                    RuleValue ruleValue = new RuleValue(splitString[0], splitString[1]);
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
