package ambiguous.autowire;

import ambiguity.autowire.Meal;
import ambiguity.autowire.MealConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MealConfig.class)
public class MealAmbiguousTest {

    @Autowired
    public Meal meal;

    @Test(expected = NoUniqueBeanDefinitionException.class)
    public void shouldThrowException() {
        System.out.println(meal);
        System.out.println(meal.getDessert());
    }
}
