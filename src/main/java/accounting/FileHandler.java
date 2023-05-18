package accounting;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static ArrayList<ArrayList<String>> getInstructionsFromFile(String filename) {
        ArrayList<ArrayList<String>> listOfInstructions = new ArrayList<>();

        log.info("trying to open file with animals" + filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                ArrayList<String> tempList = new ArrayList<>(Arrays.asList(attributes));
                listOfInstructions.add(tempList);
            }
        } catch (IOException e) {
            log.warning("File " + filename + " not found");
            e.printStackTrace();
        }

        return listOfInstructions;
    }
}
