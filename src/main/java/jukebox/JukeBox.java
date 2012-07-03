package jukebox;

import java.util.*;

public class JukeBox {
  private int credits = 0;
  private Map<String, Song> songInventory = new HashMap<String, Song>();
  private int lastId = 1;
  private List<String> playList = new ArrayList<String>();
  private int rankTotal = 0;
  private double cashBalance = 0.0;
  private List<Double> deposits = new LinkedList<Double>();

  public static int creditsFor(double payment) {
    if (payment == 0.25)
      return 1;
    else if (payment == 1.00)
      return 5;
    else if (payment == 5.00)
      return 25;
    else if (payment == 10.00)
      return 60;
    else
      return -1;
  }

  public int credits() {
    return credits;
  }

  public void deposit(double payment) {
    credits += creditsFor(payment);
    cashBalance += payment;
    deposits.add(payment);
  }

  public void select(String id) {
    Song song = songInventory.get(id);
    credits -= song.getCredits();
    playList.add(id);
  }

  public String addSong(Song song) {
    String id = "A"+lastId++;
    songInventory.put(id, song);
    rankTotal += song.getRank();
    return id;
  }

  public Song getNowPlaying() {
    return (playList.size() > 0) ? songInventory.get(playList.get(0)) : null;
  }

  public void songFinished() {
    playList.remove(0);
  }

  public List<String> getPlayList() {
    return playList;
  }

  public String getTitleOf(String id) {
    return songInventory.get(id).getTitle();
  }

  public String youDecide() {
    int selector = (int) (Math.random() * rankTotal);
    Set<String> ids = songInventory.keySet();
    for (String id : ids) {
      Song song = songInventory.get(id);
      selector -= song.getRank();
      if (selector < 0)
        return id;
    }
    return "TILT";
  }

  public Song getSong(String id) {
    return songInventory.get(id);
  }

  public double cashBalance() {
      return cashBalance;
  }

  public List<Double> deposits() {
    return deposits;
  }

  public void resetCash() {
    cashBalance = 0.0;
    deposits.clear();
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }
}
