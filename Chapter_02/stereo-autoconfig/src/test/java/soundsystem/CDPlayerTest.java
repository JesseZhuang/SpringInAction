package soundsystem;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Takes advantage of Spring’s SpringJUnit4ClassRunner to have a Spring application context automatically created when
 * the test starts.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {

  // http://stefanbirkner.github.io/system-rules/index.html Junit rule
  // Testing code that uses System.out.println() is a tricky business.
  @Rule
  public final StandardOutputStreamLog log = new StandardOutputStreamLog();

  // bean created from CDPlayer class which implements MediaPlayer interface
  @Autowired
  private MediaPlayer player;

  // creates bean from interface CompactDisc
  @Autowired
  private CompactDisc cd;

  @Test
  public void cdShouldNotBeNull() {
    assertNotNull(cd);
  }

  @Test
  public void play() {
    player.play();
    assertEquals(
            "Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n",
            log.getLog());
  }

}
