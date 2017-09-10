package com.myapp;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

/**
 * pring honors two separate properties when determining which profiles are active:
 * spring.profiles.active and spring.profiles.default.
 * There are several ways to set these properties:
 * <ul>
 * <li>As initialization parameters on DispatcherServlet
 * <li>As context parameters of a web application
 * <li>As JNDI entries
 * <li>As environment variables
 * <li>As JVM system properties
 * <li>Using the @ActiveProfiles annotation on an integration test class
 * </ul>
 */
@Configuration
public class DataSourceConfig {
  
  @Bean(destroyMethod = "shutdown")
  @Profile("dev") // can be applied at class level as well
  public DataSource embeddedDataSource() {
    return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .addScript("classpath:schema.sql")
        .addScript("classpath:test-data.sql")
        .build();
  }

  @Bean
  @Profile("prod") // implemented with @Conditional, check source
  public DataSource jndiDataSource() {
    JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
    jndiObjectFactoryBean.setJndiName("jdbc/myDS");
    jndiObjectFactoryBean.setResourceRef(true);
    jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
    return (DataSource) jndiObjectFactoryBean.getObject();
  }

}