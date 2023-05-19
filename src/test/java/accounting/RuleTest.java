package accounting;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RuleTest {

    private Animal animal1;
    private Animal animal2;
    private Rule ruleUpperCase;
    private Rule ruleDifferentFormat;
    private Rule ruleAnyType;
    private Rule ruleAnyDifferentFormat;

    @Before
    public void initialize() {
        animal1 = new Animal("ЛЕГКОЕ","МАЛЕНЬКОЕ","ВСЕЯДНОЕ");
        animal2 = new Animal("ТЯЖЕЛОЕ","СРЕДНЕЕ","ПЛОТОЯДНОЕ");

        ruleUpperCase = new Rule("ВЕС", "ЛЕГКОЕ");
        ruleDifferentFormat = new Rule("ВеС", "ЛегКОе");
        ruleAnyType = new Rule("ВЕС", "ЛЮБОЙ");
        ruleAnyDifferentFormat = new Rule("ВЕС", "ЛюБоЙ");
    }

    @Test
    public void matches() {
        assertTrue(ruleUpperCase.matches(animal1));
        assertTrue(ruleDifferentFormat.matches(animal1));

        assertFalse(ruleUpperCase.matches(animal2));
        assertFalse(ruleDifferentFormat.matches(animal2));

        assertTrue(ruleAnyType.matches(animal1));
        assertTrue(ruleAnyType.matches(animal2));

        assertTrue(ruleAnyDifferentFormat.matches(animal1));
        assertTrue(ruleAnyDifferentFormat.matches(animal2));
    }
}