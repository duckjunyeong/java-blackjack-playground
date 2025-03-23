package backjack.Model;

public class Player extends Participant {
  private Money dividends;

  public Player(Name name, Money dividends){
    super(name);
    this.dividends = dividends;
  }

  public Player(Name name){
    super(name);
    this.dividends = new Money(0);
  }
}
