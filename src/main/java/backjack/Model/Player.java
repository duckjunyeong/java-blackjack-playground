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

  public Money getDividends(){
    return dividends;
  }

  public void setDividends(Money dividends){
    this.dividends = dividends;
  }

  @Override
  public String getCardAllInfo(){
    return getCardInfo();
  }

  @Override
  public int getTurnOrder(){
    return 2;
  }
}
