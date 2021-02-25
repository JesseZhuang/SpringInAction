package soundsystem;

public class BlankDisc implements CompactDisc {

  private String title;
  private String artist;

  public BlankDisc(String title, String artist) {
    this.title = title;
    this.artist = artist;
  }

  public void play() {
    System.out.println("Playing " + title + " by " + artist);
  }

  public void playTrack(int trackNumber) {
    System.out.println("Playing track number " + trackNumber + " of the CD.");
  }

}
