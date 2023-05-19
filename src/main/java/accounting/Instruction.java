package accounting;

import lombok.Data;

import java.util.List;
import java.util.logging.Logger;

@Data
public class Instruction {

    private String instructionName;
    private List<Rule> listOfRules;

    private static final Logger log = Logger.getLogger(String.valueOf(Instruction.class));

    public int countAnimalsByInstruction(List<Animal> animals) {
        int count = 0;

        for (Animal animal : animals) {
            boolean match = true;
            for (Rule ruleValue : listOfRules) {
                if (!ruleValue.matches(animal)) match = false;
            }
            if (match) count++;
        }
        log.info("Number of animals that meet the rules:" + listOfRules + " - " + count);
        return count;
    }
}
