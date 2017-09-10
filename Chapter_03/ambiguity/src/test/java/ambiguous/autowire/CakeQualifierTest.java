package ambiguous.autowire;

import ambiguity.autowire.Cake;
import ambiguity.autowire.Dessert;
import ambiguity.autowire.MealConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MealConfig.class)
public class CakeQualifierTest {

    @Autowired
    @Qualifier("soft")
    public Dessert dessert1;

    @Autowired
    @Qualifier("cake")
    public Dessert dessert;

    @Test
    public void shouldBeCakeTest(){
        assertThat(dessert1, instanceOf(Cake.class));
        assertThat(dessert, instanceOf(Cake.class));
    }
}
