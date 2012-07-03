package jukebox;

public class Song {
  private String title;
  private String artist;
  private String duration;
  private int credits;
  private int rank;

  public Song(String title, String artist, String duration, int credits, int rank) {
    this.title = title;
    this.artist = artist;
    this.duration = duration;
    this.credits = credits;
    this.rank = rank;
  }

  public String getTitle() {
    return title;
  }

  public String getArtist() {
    return artist;
  }

  public String getDuration() {
    return duration;
  }

  public int getCredits() {
    return credits;
  }

  public int getRank() {
    return rank;
  }
}
