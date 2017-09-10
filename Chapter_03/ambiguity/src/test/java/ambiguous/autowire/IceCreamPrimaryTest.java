package ambiguous.autowire;

import ambiguity.autowire.Dessert;
import ambiguity.autowire.IceCream;
import ambiguity.autowire.IceCreamPrimaryConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = IceCreamPrimaryConfig.class)
public class IceCreamPrimaryTest {

    @Autowired
    public Dessert dessert;

    @Test
    public void iceCreamShouldBeChosen(){
        assertEquals(dessert.getCalories(), 81);
        assertThat(dessert, instanceOf(IceCream.class));
    }
}
