package com.habuma.restfun;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExistsCondition implements Condition {

  /**
   * check for the presence of an environment property named magic
   * other things can be done with the context:
   * <ul>
   *     <li>Check for bean definitions via the BeanDefinitionRegistry</li>
   *     <li>Check for the presence of beans, dig into bean properties via the ConfigurableListableBeanFactory</li>
   *     <li>Check for the presence and values of environment variables</li>
   *     <li>Read and inspect the contents of resources loaded via the ResourceLoader</li>
   *     <li>Load and check for the presence of classes via the ClassLoader</li>
   * </ul>
   * AnnotatedTypeMetadata offers you a chance to inspect annotations that may also be placed on the @Bean method:
   * <ul>
   *     <li>isAnnotated()  check to see if the @Bean method is annotated with any particular annotation type</li>
   *     <li></li>
   * </ul>
   *
   * Starting with Spring 4, the @Profile annotation has been refactored to be based on
   * @Conditional and the Condition interface.
   */
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    Environment env = context.getEnvironment();
    return env.containsProperty("magic");
  }
  
}
