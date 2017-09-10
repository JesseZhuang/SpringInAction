package ambiguity.autowire;

import org.springframework.stereotype.Component;

@Component
public class Cookies implements Dessert {

    @Override
    public int getCalories() {
        return 80;
    }
}
