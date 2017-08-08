package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * there are times when automatic configuration isn’t an option and you must configure Spring explicitly. For instance,
 * let’s say that you want to wire components from some third-party library into your application.
 * JavaConfig is the preferred option for explicit configuration because it’s more powerful, type-safe,
 * and refactor-friendly. JavaConfig is often set apart in a separate package.
 */
@Configuration
public class CDPlayerConfig {

  // By default, the bean will be given an ID that is the same as the @Bean-annotated method’s name.
  @Bean
  public CompactDisc compactDisc() {
    return new SgtPeppers();
  }

  // @Bean(name="lonelyHeartsClubBand") to customize the ID
  @Bean(name="lonelyHeartsClubBand")
  public CompactDisc sgtPeppers() {
    return new SgtPeppers();
  }
  
  @Bean
  public CDPlayer cdPlayer(CompactDisc compactDisc) {
    return new CDPlayer(compactDisc);
  }

  // By default, all beans in Spring are singletons
  @Bean
  public CDPlayer cdPlayer() {
    return new CDPlayer(sgtPeppers());
  }

  // will be given the same instance of SgtPeppers
  @Bean
  public CDPlayer anotherCDPlayer() {
    return new CDPlayer(sgtPeppers());
  }

  @Bean
  public CompactDisc randomBeatlesCD() {
    int choice = (int) Math.floor(Math.random() * 4);
    if (choice == 0) {
      return new SgtPeppers();
    } else if (choice == 1) {
      // return new WhiteAlbum();
    } else if (choice == 2) {
      // return new HardDaysNight();
    } else {
      // return new Revolver();
    }
    return new SgtPeppers();
  }

}
