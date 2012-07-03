package jukebox.fixtures;

public class CreditsForPayment {
  private double payment;
  public void setPayment(double payment) {
    this.payment = payment;
  }

  public int credits() {
    return jukebox.JukeBox.creditsFor(payment);
  }
}
