package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * You could have annotated HomeController with @Component, and it would have had the same effect, but it would have
 * been less expressive about what type of component HomeController is.
 */
@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {

  /**
   * This String will be interpreted by Spring MVC as the name of the view that will be rendered. DispatcherServlet
   * will ask the view resolver to resolve this logical view name into an actual view. Given the way you configured
   * InternalResourceViewResolver, the view name “home” will be resolved as a JSP at /WEB-INF/views/home.jsp.
   * @param model
   * @return
   */
  @RequestMapping(method = GET)
  public String home(Model model) {
    return "home";
  }

}
