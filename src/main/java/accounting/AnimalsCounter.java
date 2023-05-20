package accounting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnimalsCounter {

    private List<Animal> animals;
    private List<Instruction> instructions;

    /**
     * Uses private method to count animals and prints the returned result in console.
     */
    public void printCount() {
        for (Instruction instruction : instructions) {
            System.out.println(instruction.getInstructionName() + " - " + countAnimalsByInstruction(animals, instruction));
        }
    }

    /**
     * Method iterates through the animals, and then rule by rule. If at least one of the rules doesn't match
     * with the animal field, it sets boolean parameter to false and not count this animal.
     * @param animals list of all added animals
     * @param instruction object, that contains rules
     * @return number of animals, that fit the rules
     */
    private int countAnimalsByInstruction(List<Animal> animals, Instruction instruction) {
        int count = 0;

        for (Animal animal : animals) {
            boolean match = true;
            for (Rule rule : instruction.getListOfRules()) {
                if (!rule.matches(animal)) match = false;
            }
            if (match) count++;
        }
        return count;
    }
}
