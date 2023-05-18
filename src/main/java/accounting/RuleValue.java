package accounting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleValue {

    private String typeOfRule;
    private String ruleValue;

    public boolean matches(Animal animal) {
        if (ruleValue.equals("ЛЮБОЙ")) return true;

        String[] valueArray = ruleValue.split("\\|");
        String tempValue = "";

        switch (typeOfRule) {
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

        for (String element : valueArray) {
            if (tempValue.equals(element)) return true;
        }

        return false;
    }
}