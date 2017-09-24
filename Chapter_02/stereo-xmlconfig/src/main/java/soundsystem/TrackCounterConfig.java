package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import soundsystem.collections.BlankDisc;

import java.util.Arrays;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        BlankDisc cd = new BlankDisc("Sgt. Pepper's Lonely Hearts Club Band",
                "The Beatles",
                Arrays.asList(
                        "Sgt. Pepper's Lonely Hearts Club Band",
                        "With a Little Help from My Friends",
                        "Lucy in the Sky with Diamonds",
                        "Getting Better",
                        "Fixing a Hole",
                        "She's Leaving Home",
                        "Being for the Benefit of Mr. Kite!",
                        "Within You Without You",
                        "When I'm Sixty-Four",
                        "Lovely Rita",
                        "Good Morning Good Morning",
                        "Sgt. Pepper's Lonely Hearts Club Band (Reprise)",
                        "A Day in the Life",
                        "Dust My Shoulders Off"
                ));
        // ...other tracks omitted for brevity...
        return cd;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
