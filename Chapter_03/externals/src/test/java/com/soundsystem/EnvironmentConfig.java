package com.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * This properties file is loaded into Spring’s Environment, from which it can be retrieved later.
 * Environment also offers some methods for checking which profiles are active
 */
@Configuration
@PropertySource("classpath:/com/soundsystem/app.properties")
public class EnvironmentConfig {

  @Autowired
  Environment env;
  
  @Bean
  public BlankDisc blankDisc() {
    int connectionCount =
            env.getProperty("db.connection.count", Integer.class,30);
    System.out.println("conn_coaunt: " + connectionCount);
    return new BlankDisc(
        env.getProperty("disc.title"),
        env.getProperty("disc.artist"));
  }

}
