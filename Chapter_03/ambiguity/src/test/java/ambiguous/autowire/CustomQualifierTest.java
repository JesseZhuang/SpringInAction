package ambiguous.autowire;

import ambiguity.autowire.Dessert;
import ambiguity.autowire.IceCream;
import ambiguity.autowire.MealConfig;
import ambiguity.autowire.custom.qualifier.Cold;
import ambiguity.autowire.custom.qualifier.Creamy;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MealConfig.class)
public class CustomQualifierTest {

    @Autowired
    @Cold
    @Creamy
    public Dessert dessert;

    @Test
    public void shouldBeIceCream(){
        assertThat(dessert, CoreMatchers.instanceOf(IceCream.class));
    }
}
