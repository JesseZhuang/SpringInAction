package soundsystem;
import org.springframework.stereotype.Component;

// default bean ID sgtPeppers derived from class name
// alternative @Named("lonelyHeartsClub") (JSR-330) @Component("lonelyHeartsClub")
@Component
public class SgtPeppers implements CompactDisc {

  private String title = "Sgt. Pepper's Lonely Hearts Club Band";  
  private String artist = "The Beatles";

  public void play() {
    System.out.println("Playing " + title + " by " + artist);
  }
  
}
