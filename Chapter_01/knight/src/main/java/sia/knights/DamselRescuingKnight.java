package sia.knights;

public class DamselRescuingKnight implements Knight {

  private RescueDamselQuest quest;

  /* DamselResuingKnight creates its own quest in the constructor, which makes the two tightly coupled. This knight
  cannot do other quests easily. Difficult to test, reuse. "Whack-a-mole" bug behavior.
   */
  public DamselRescuingKnight() {
      this.quest = new RescueDamselQuest();
  }

  public void embarkOnQuest() {
      quest.embark();
  }

}
