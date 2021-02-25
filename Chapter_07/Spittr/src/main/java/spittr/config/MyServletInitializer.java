package spittr.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;

/**
 * One of the nice things about working with a Java-based initializer is that (unlike with web.xml)
 * you can define as many initializer classes as you want.
 * <p>
 * There’s no need to declare the mapping for the filters; any filter returned from getServletFilters() will
 * automatically be mapped to DispatcherServlet.
 */
public class MyServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        Dynamic myServlet =
                servletContext.addServlet("myServlet", MyServlet.class);
        myServlet.addMapping("/custom/**"); //map the servlet

        // register a filter
        javax.servlet.FilterRegistration.Dynamic filter =
                servletContext.addFilter("myFilter", MyFilter.class);
        filter.addMappingForUrlPatterns(null, false, "/custom/*");
    }

}
