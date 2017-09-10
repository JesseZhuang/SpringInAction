package ambiguity.autowire;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("soft")
public class Cake implements Dessert {

    @Override
    public int getCalories() {
        return 100;
    }
}
