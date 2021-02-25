package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spittr.web.WebConfig;

/**
 * <p>In a Servlet 3.0 environment, the container looks for any classes in the classpath that implement the
 * javax.servlet .ServletContainerInitializer interface; if any are found, they’re used to configure
 * the servlet container.
 * <p>Spring supplies an implementation of that interface called SpringServlet-ContainerInitializer that, in turn,
 * seeks out any classes that implement WebApplicationInitializer and delegates to them for configuration.
 * Spring 3.2 introduced a convenient base implementation of WebApplicationInitializer called
 * AbstractAnnotationConfigDispatcherServletInitializer.
 * <p>
 * It’s important to realize that configuring DispatcherServlet via AbstractAnnotationConfigDispatcherServletInitializer
 * is an alternative to the traditional web.xml file. Although you can include a web.xml file alongside a subclass
 * ofAbstractAnnotationConfigDispatcherServletInitializer if you like, it’s not necessary. It will only work when
 * deploying to a server that supports Servlet 3.0, such as Apache Tomcat 7 or higher.
 */
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  /**
   * The @Configuration class’s returned getRootConfigClasses() will be used to configure the application context
   * created by ContextLoaderListener.
   * @return
   */
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { RootConfig.class };
  }

  /**
   * <p>
   * Asks that DispatcherServlet load its application context with beans defined in the WebConfig
   * configuration class (using Java configuration).
   * <p>
   * But in Spring web applications, there’s often another application context. This other application context is
   * created by ContextLoaderListener. Whereas DispatcherServlet is expected to load beans containing web components
   * such as controllers, view resolvers, and handler mappings, ContextLoaderListener is expected to load the other
   * beans in your application. These beans are typically the middle-tier and data-tier components that drive the
   * back end of the application.
   * <p>
   * The @Configuration classes returned from getServletConfigClasses() will define beans for DispatcherServlet’s
   * application context.
   * @return
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { WebConfig.class };
  }

  /**
   * Identifies one or more paths that DispatcherServlet will be mapped to.
   * @return
   */
  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}