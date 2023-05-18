package accounting;

import lombok.Data;

import java.util.List;

@Data
public class Rule {

    private String ruleName;
    private List<RuleValue> listOfRules;

}
