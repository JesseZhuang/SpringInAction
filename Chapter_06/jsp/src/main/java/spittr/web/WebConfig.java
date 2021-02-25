package spittr.web;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {

  /**
   * <p>InternalResourceViewResolver can resolve view names into JSP files fronted by JstlView to expose JSTL locale and
   * resource bundle variables to JSTL’s formatting and message tags.
   * <p>Spring provides two JSP tag libraries, one for form-to-model binding and one providing general utility features.
   * @return
   */
  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    // JstlView
    resolver.setViewClass(
            org.springframework.web.servlet.view.JstlView.class);
    return resolver;
  }
  
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }
  
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    super.addResourceHandlers(registry);
  }
  
  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = 
        new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("file:///Users/habuma/messages");
    // By setting it to messages, you can expect ResourceBundleMessageResolver to resolve messages from properties
    // files at the root of the classpath whose names are derived from that base name.
    // messageSource.setBasename("messages");
    // messageSource.setBasename("file:///etc/spittr/messages");
    messageSource.setCacheSeconds(10);
    return messageSource;
  }
 
}
