package sia.knights;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class BraveKnightTest {

  @Test
  public void knightShouldEmbarkOnQuest() {
    //Quest can be a mock implementation. Benefit of loose coupling.
    Quest mockQuest = mock(Quest.class);
    BraveKnight knight = new BraveKnight(mockQuest);
    knight.embarkOnQuest();
    //verify method called exactly once
    verify(mockQuest, times(1)).embark();
  }

}
