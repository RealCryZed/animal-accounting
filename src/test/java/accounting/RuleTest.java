package accounting;

import accounting.models.Animal;
import accounting.models.Rule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RuleTest {

    private Animal animal1;
    private Animal animal2;
    private Animal animal3;
    private Rule ruleUpperCase;
    private Rule ruleDifferentFormat;
    private Rule ruleAnyType;
    private Rule ruleAnyDifferentFormat;

    @Before
    public void initialize() {
        animal1 = new Animal("ЛЕГКОЕ","МАЛЕНЬКОЕ","ВСЕЯДНОЕ");
        animal2 = new Animal("ТЯЖЕЛОЕ","СРЕДНЕЕ","ПЛОТОЯДНОЕ");

        animal3 = new Animal();
        animal3.setWeight("Легкое");

        ruleUpperCase = new Rule("ВЕС", "ЛЕГКОЕ");
        ruleDifferentFormat = new Rule("ВеС", "ЛегКОе");
        ruleAnyType = new Rule("ВЕС", "ЛЮБОЙ");
        ruleAnyDifferentFormat = new Rule("ВЕС", "ЛюБоЙ");
    }

    @Test
    public void testMatches_UpperCaseRuleValue() {
        assertTrue(ruleUpperCase.matches(animal1));
        assertFalse(ruleUpperCase.matches(animal2));
    }
    @Test
    public void testMatches_DifferentFormatRule() {
        assertTrue(ruleDifferentFormat.matches(animal1));
        assertFalse(ruleDifferentFormat.matches(animal2));
    }

    @Test
    public void testMatches_AnyTypeOfRule_returnTrue() {
        assertTrue(ruleAnyType.matches(animal1));
        assertTrue(ruleAnyType.matches(animal2));
    }

    @Test
    public void testMatches_RuleInAnyFormat_returnTrue() {
        assertTrue(ruleAnyDifferentFormat.matches(animal1));
        assertTrue(ruleAnyDifferentFormat.matches(animal2));
    }

    @Test
    public void testMatches_OneValueInAnimal_returnTrue() {
        assertTrue(ruleUpperCase.matches(animal3));
        assertTrue(ruleAnyDifferentFormat.matches(animal3));
    }
}