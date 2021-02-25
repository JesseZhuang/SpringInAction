package soundsystem;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * A spring wiring specification expressed in Java. By default @ComponentScan scans same package and sub packages.
 */
@Configuration
/*
 Other variations not type safe (refactor may make it wrong):
 @ComponentScan("soundsystem")
 @ComponentScan(basePackages="soundsystem")
 @ComponentScan(basePackages={"soundsystem", "video"})
 Type safe variation:
 @ComponentScan(basePackageClasses={CDPlayer.class, DVDPlayer.class}) could be marker interface
 */
@ComponentScan
public class CDPlayerConfig { 
}
