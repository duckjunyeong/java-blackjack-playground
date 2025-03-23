package backjack.Model;

public class Player {
  private Name name;
  private Money dividends;
  private Cards myCards;

  public Player(Name name, Money dividends){
    this.name = name;
    this.dividends = dividends;
    this.myCards = new Cards();
  }


}
