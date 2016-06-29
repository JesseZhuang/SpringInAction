package sia.knights;

public class KnightWithMinstrel implements Knight{
    private Quest quest;
    //A knight should not manage his minstrel, a minstrel should sing about knights as its job
    private Minstrel minstrel;

    public KnightWithMinstrel(Quest quest, Minstrel minstrel) {
        this.quest = quest;
        this.minstrel = minstrel;
    }

    //public void embarkOnQuest throws QuestException (){
    public void embarkOnQuest (){
        minstrel.singBeforeQuest();
        quest.embark();
        minstrel.singAfterQuest();
    }
}
