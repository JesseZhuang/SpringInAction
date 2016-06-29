package sia.knights;
  
public class BraveKnight implements Knight {

  private Quest quest;

  //does not create its own quest. DI Constructor injection.
  //Quest is an interface for polymorphism.
  public BraveKnight(Quest quest) {
    this.quest = quest;
  }

  public void embarkOnQuest() {
    quest.embark();
  }

}
