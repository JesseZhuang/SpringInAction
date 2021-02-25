package spittr.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spittr.web.WebConfig;

/**
 * In a typical Spring MVC application, you need a DispatcherServlet and a ContextLoaderListener.
 * AbstractAnnotationConfigDispatcherServletInitializer will register these automatically for you,
 * but if you’re registering them in web.xml, you’ll need to do all the work.
 */
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { RootConfig.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { WebConfig.class };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

  /**
   * To register one or more filters and map them to DispatcherServlet, all you need to do is override the
   * getServletFilters() method of AbstractAnnotationConfigDispatcherServletInitializer.
   * @return An array of Filters.
   */
  @Override
  protected Filter[] getServletFilters() {
    return new Filter[] {new MyFilter()};
  }

  /**
   * By overriding customizeRegistration(), you can apply additional configuration to DispatcherServlet. If you plan
   * to use Servlet 3.0 support for multipart configuration, you need to enable DispatcherServlet’s registration
   * to enable multipart requests.
   * <p>
   * With the ServletRegistration.Dynamic that’s given to customizeRegistration(),
   * you can do several things, including set the load-on-startup priority by calling setLoadOnStartup(),
   * set an initialization parameter by calling setInitParameter().
   * @param registration
   */
  @Override
  protected void customizeRegistration(Dynamic registration) {
//    If you’re configuring DispatcherServlet in a servlet initializer class that implements WebApplicationInitializer
//    DispatcherServlet ds = new DispatcherServlet();
//    Dynamic registration = context.addServlet("appServlet", ds);
//    registration.addMapping("/");
//    registration.setMultipartConfig(
//            new MultipartConfigElement("/tmp/spittr/uploads"));
    registration.setMultipartConfig(
        new MultipartConfigElement("/tmp/spittr/uploads", 2097152, 4194304, 0));
  }
 
}