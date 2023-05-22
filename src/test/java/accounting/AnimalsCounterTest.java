package accounting;

import accounting.functions.AnimalsCounter;
import accounting.models.Animal;
import accounting.models.Instruction;
import accounting.models.Rule;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class AnimalsCounterTest {

    private AnimalsCounter animalsCounter;
    private Instruction instruction;

    @Before
    public void initialize() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("ЛЕГКОЕ","МАЛЕНЬКОЕ","ВСЕЯДНОЕ"));
        animals.add(new Animal("ЛеГкОЕ","МалЕНЬкОЕ","вСЕядНоЕ"));
        animals.add(new Animal("ТЯЖЕЛОЕ","НЕВЫСОКОЕ","ПЛОТОЯДНОЕ"));
        animals.add(new Animal("легкое","маленькое","всеядное"));

        List<Rule> rules = new ArrayList<>();
        rules.add(new Rule("ВЕС", "Легкое"));
        rules.add(new Rule("РОСТ", "маленькое"));
        rules.add(new Rule("ТИП", "ЛЮБОЙ"));

        instruction = new Instruction("ПРАВИЛО1", rules);

        animalsCounter = new AnimalsCounter(animals, Collections.singletonList(instruction));
    }

    @Test
    public void count_Equals3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = AnimalsCounter.class.getDeclaredMethod("countAnimals", List.class, Instruction.class);
        method.setAccessible(true);
        assertEquals(3, method.invoke(animalsCounter, animalsCounter.getAnimals(), instruction));
    }
}