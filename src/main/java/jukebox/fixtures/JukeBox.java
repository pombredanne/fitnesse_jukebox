package jukebox.fixtures;

import jukebox.Song;

import java.util.*;

public class JukeBox {
  public static jukebox.JukeBox jukeBox;
  private double averageYouDecideCredits = 0;
  public static Map<String, Integer> youDecideCounts = new HashMap<String, Integer>();

  public JukeBox() {
    jukeBox = new jukebox.JukeBox();
  }

  public int credits() {
    return jukeBox.credits();
  }

  public void setCredits(int credits) {
    jukeBox.setCredits(credits);
  }

  public void deposit(double payment) {
    jukeBox.deposit(payment);
    
  }

  public void select(String id) {
    jukeBox.select(id);
  }

  public String nowPlaying() {
    Song nowPlaying = jukeBox.getNowPlaying();
    return nowPlaying == null ? "nothing" : nowPlaying.getTitle();
  }

  public void songFinished() {
    jukeBox.songFinished();
  }

  public void repeatYouDecideTimesAndCountResults(int times) {
    youDecideCounts.clear();
    double credis = 0;
    for (int i=0; i<times; i++) {
      String id = jukeBox.youDecide();
      Song song = jukeBox.getSong(id);
      credis += song.getCredits();
      if (youDecideCounts.get(id) == null)
        youDecideCounts.put(id, 0);
      youDecideCounts.put(id, youDecideCounts.get(id)+1);
    }
    averageYouDecideCredits = credis / (double)times;
  }

  public double averageYouDecideCredits() {
    return averageYouDecideCredits;
  }

  public double cashBalance() {
    return jukeBox.cashBalance();
  }

  public List<String> deposits() {
    List<String> retval = new ArrayList<String>();
    for (Double deposit : jukeBox.deposits())
      retval.add(deposit.toString());
    return retval;
  }

  public void resetCash() {
    jukeBox.resetCash();  
  }
}
