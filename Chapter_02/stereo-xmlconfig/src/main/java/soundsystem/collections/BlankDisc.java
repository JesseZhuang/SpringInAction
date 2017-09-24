package soundsystem.collections;

import java.util.List;

import soundsystem.CompactDisc;

public class BlankDisc implements CompactDisc {

  private String title;
  private String artist;
  private List<String> tracks;

  public BlankDisc(String title, String artist, List<String> tracks) {
    this.title = title;
    this.artist = artist;
    this.tracks = tracks;
  }

  public void play() {
    System.out.println("Playing " + title + " by " + artist);
    for (String track : tracks) {
      System.out.println("-Track: " + track);
    }
  }

  @Override
  public void playTrack(int trackNumber) {
    System.out.println("Playing track " + trackNumber + " : " + tracks.get(trackNumber));
  }

}
