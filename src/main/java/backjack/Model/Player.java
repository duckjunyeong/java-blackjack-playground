package backjack.Model;

public class Player {
  private Name name;
  private Money dividends;
  private Cards cards;

  public Player(Name name, Money dividends){
    this.name = name;
    this.dividends = dividends;
    this.cards = new Cards();
  }

  public Player(Name name){
    this.name = name;
    this.dividends = new Money(0);
    this.cards = new Cards();
  }


  public String getMyCardInfo() {
    return name.getName() + "가 가지고 있는 카드: " + cards.getCardListInfo();
  }

  public void setCards(Cards cards) {
    this.cards = cards;
  }
}
