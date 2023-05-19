package accounting;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Instruction {

    private String instructionName;
    private List<RuleValue> listOfRules;

    public int countAnimalsByRule(List<Animal> animals) {
        int count = 0;

        for (Animal animal : animals) {
            boolean match = true;
            for (RuleValue ruleValue : listOfRules) {
                if (!ruleValue.matches(animal)) match = false;
            }
            if (match) count++;
        }

        return count;
    }
}
