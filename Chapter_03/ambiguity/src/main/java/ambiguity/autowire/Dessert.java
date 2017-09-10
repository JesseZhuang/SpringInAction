package ambiguity.autowire;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public interface Dessert {

    int getCalories();
}
