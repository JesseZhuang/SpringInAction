package ambiguity.autowire;

import ambiguity.autowire.custom.qualifier.Cold;
import ambiguity.autowire.custom.qualifier.Creamy;
import org.springframework.stereotype.Component;

@Component
@Cold
@Creamy
public class IceCream implements Dessert {

    @Override
    public int getCalories() {
        return 81;
    }
}
