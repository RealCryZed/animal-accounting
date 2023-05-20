package accounting.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rule {

    private String ruleType;
    private String ruleName;

    @Override
    public String toString() {
        return ruleType + "=" + ruleName;
    }

    /**
     * If rule equals 'ЛЮБОЙ' - return true. If ruleName equals one of the animal field, then it returns true, else false
     * @param animal
     * @return true or false
     */
    public boolean matches(Animal animal) {
        if (ruleName.toUpperCase().equals("ЛЮБОЙ")) return true;

        String[] valueArray = ruleName.toUpperCase().split("\\|");
        String tempValue = "";

        switch (ruleType.toUpperCase()) {
            case "ВЕС":
                tempValue = animal.getWeight();
                break;
            case "РОСТ":
                tempValue = animal.getHeight();
                break;
            case "ТИП":
                tempValue = animal.getType();
                break;
            default: break;
        }

        // If two or more rules are written with a '|' sign, then we go through each rule and compare it with tempValue
        for (String element : valueArray) {
            if (tempValue.toUpperCase().equals(element)) return true;
        }

        return false;
    }
}
