package accounting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.logging.Logger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnimalsCounter {

    private List<Animal> animals;
    private List<Instruction> instructions;

    private static final Logger log = Logger.getLogger(String.valueOf(AnimalsCounter.class));

    public void countAndPrint() {
        for (Instruction instruction : instructions) {
            log.info("Counting animals in instruction: " + instruction.getInstructionName());
            System.out.println(instruction.getInstructionName() + " - " + countAnimalsByInstruction(animals, instruction));
        }
    }

    private int countAnimalsByInstruction(List<Animal> animals, Instruction instruction) {
        int count = 0;

        for (Animal animal : animals) {
            boolean match = true;
            for (Rule ruleValue : instruction.getListOfRules()) {
                if (!ruleValue.matches(animal)) match = false;
            }
            if (match) count++;
        }
        log.info("Number of animals that meet the rules:" + instruction.getListOfRules() + " - " + count);
        return count;
    }
}
