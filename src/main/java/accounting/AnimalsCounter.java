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
            System.out.println(instruction.getInstructionName() + " - " + instruction.countAnimalsByInstruction(animals));
        }
    }
}
