package accounting;

import lombok.Data;

import java.util.List;

@Data
public class Instruction {

    private String instructionName;
    private List<Rule> listOfRules;
}
