package accounting;

import lombok.Data;

import java.util.List;

@Data
public class Rule {

    private String ruleName;
    private List<RuleValue> listOfRules;

//    public void setRuleName(String ruleName) {
//        this.ruleName = ruleName;
//    }
//
//    public void setListOfRules(List<RuleValue> rules) {
//        this.listOfRules = rules;
//        for (String rulevalue : rules) {
//            RuleValue rule = new RuleValue();
//            listOfRules.add();
//        }
//    }
}
