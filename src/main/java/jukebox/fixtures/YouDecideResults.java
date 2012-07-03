package jukebox.fixtures;

public class YouDecideResults {
  private String id;

  public void setId(String id) {
    this.id = id;
  }

  public int timesPlayed() {
    Integer count = JukeBox.youDecideCounts.get(id);
    return count == null ? 0 : count;
  }
}
