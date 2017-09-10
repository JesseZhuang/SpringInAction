package ambiguity.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Meal {

    @Autowired
    @Lazy
    private Dessert dessert;

    public Meal () {
        System.out.println("Meal initialized.");
    }

    public Dessert getDessert(){
        return dessert;
    }
}
