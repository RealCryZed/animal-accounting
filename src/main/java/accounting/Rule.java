package accounting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rule {

    private String ruleType;
    private String ruleValue;

    @Override
    public String toString() {
        return ruleType + "=" + ruleValue;
    }

    public boolean matches(Animal animal) {
        if (ruleValue.toUpperCase().equals("ЛЮБОЙ")) return true;

        String[] valueArray = ruleValue.toUpperCase().split("\\|");
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

        for (String element : valueArray) {
            if (tempValue.toUpperCase().equals(element)) return true;
        }

        return false;
    }
}
