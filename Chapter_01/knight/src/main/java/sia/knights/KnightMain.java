package sia.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.
                   ClassPathXmlApplicationContext;
import sia.knights.config.KnightConfig;

public class KnightMain {

  private static void useXML(){
    // An application context loads bean definitions and wires them together.
    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(
                    "META-INF/spring/knight.xml");
    Knight knight = context.getBean(Knight.class);
    knight.embarkOnQuest();
    context.close();
  }

  private static void useAnnotation(){
    ApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
    Knight knight = context.getBean(Knight.class);
    knight.embarkOnQuest();
    //context.close();
  }

  public static void main(String[] args) throws Exception {
    useXML();
    useAnnotation();
  }

}
