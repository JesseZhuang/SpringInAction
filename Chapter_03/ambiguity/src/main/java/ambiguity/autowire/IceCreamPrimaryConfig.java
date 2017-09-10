package ambiguity.autowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class IceCreamPrimaryConfig {

    @Bean
    @Primary
    public Dessert iceCream() {
        return new IceCream();
    }
}
