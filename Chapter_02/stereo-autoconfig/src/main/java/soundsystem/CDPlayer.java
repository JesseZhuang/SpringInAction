package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * To be turned into a Spring bean. Other types of @Component include @Repository and @Aspect.
 */
@Component
public class CDPlayer implements MediaPlayer {
  private CompactDisc cd;

  /*
    Autowiring is a means of letting Spring automatically satisfy a bean’s dependencies by finding other beans in
    the application context that are a match to the bean’s needs. Can be used on constructor, setter, or any method.
    @Autowired(required=false) leaves bean unwired if no match. By default, throw exception if no or multiple matches.
    @Inject comes from the Java Dependency Injection specification.
   */
  // pass in a bean that is assignable to CompactDisc, SgtPepper class
  @Autowired
  public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

  public void play() {
        cd.play();
    }

  @Autowired
  public void setCompactDisc(CompactDisc cd) {
    this.cd = cd;
  }

  @Autowired
  public void insertDisc(CompactDisc cd) {
    this.cd = cd;
  }

}
