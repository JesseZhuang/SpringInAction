package sia.knights;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.PrintStream;

//Only spring through configuration know how the pieces are wired together.
@Configuration
public class KnightConfig {

  @Bean
  public Knight knight() {
    return new BraveKnight(quest());
  }

  @Bean
  public Knight knight1(){return new BraveKnight(quest()); }

  @Bean
  public Quest quest() {
    return new SlayDragonQuest(stream());
  }

  @Bean
  public PrintStream stream() {
    return new FakePrintStream();
  }

}
