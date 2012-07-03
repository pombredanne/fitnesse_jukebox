package jukebox.fixtures;

import jukebox.Song;

public class SongInventory {
  private String title;
  private String artist;
  private String duration;
  private int credits;
  private int rank;
  private String lastId;

  public void setTitle(String title) {
    this.title = title;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

  public String id() {
    return lastId;
  }

  public void execute() {
    Song song = new Song(title, artist, duration, credits, rank);
    lastId = JukeBox.jukeBox.addSong(song);
  }

  public void setRank(int rank) {
    this.rank = rank;
  }
}
