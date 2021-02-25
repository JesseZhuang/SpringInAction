package spittr.web;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * <p>
 * Spring comes with two out-of-the-box implementations of MultipartResolver to choose from: CommonsMultipartResolver
 * —Resolves multipart requests using Jakarta Commons FileUpload and
 * StandardServletMultipartResolver—Relies on Servlet 3.0 support for multi-part requests (since Spring 3.1).
 * <p>
 * Simple form submission example:<br>
 * firstName=Charles&lastName=Xavier&email=professorx%40xmen.org&username=professorx&password=letmein01
 * <p>
 * Although this encoding scheme is simple and sufficient for typical text-based form submissions,
 * it isn’t robust enough to carry binary data such as an uploaded image.
 * <p>
 * Multipart form data example:
 * <pre>
 * ------WebKitFormBoundaryqgkaBn8IHJCuNmiW
 * Content-Disposition: form-data; name="username"
 * professorx
 * ------WebKitFormBoundaryqgkaBn8IHJCuNmiW
 * Content-Disposition: form-data; name="password"
 * letmein01
 * ------WebKitFormBoundaryqgkaBn8IHJCuNmiW
 * Content-Disposition: form-data; name="profilePicture"; filename="me.jpg"
 * Content-Type: image/jpeg
 * [[ Binary image data goes here ]]
 * ------WebKitFormBoundaryqgkaBn8IHJCuNmiW--
 * </pre>
 */
@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(TemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    @Bean
    public TemplateResolver templateResolver() {
        TemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public MultipartResolver multipartResolver() throws IOException {
//        you must specify multipart configuration in the servlet configuration
        return new StandardServletMultipartResolver();
        // return new CommonsMultipartResolver();
//        CommonsMultipartResolver multipartResolver =
//                new CommonsMultipartResolver();

//        Unlike StandardServletMultipartResolver, there’s no need to configure a temporary file location with
//        CommonsMultipartResolver. By default, the location is the servlet container’s temporary directory.
//        But you can specify a different location by setting the uploadTempDir property.

//        multipartResolver.setUploadTempDir(
//                new FileSystemResource("/tmp/spittr/uploads"));
//        multipartResolver.setMaxUploadSize(2097152);
//        multipartResolver.setMaxInMemorySize(0);
    }

}
