package backjack.Model;

import backjack.utils.Cards.Card;

public abstract class Participant implements HandHolder {
  private Cards cards;
  private Name name;
  private Money revenue;

  public Participant(Name name){
    this.name = name;
    this.cards = new Cards();
    this.revenue = new Money(0);
  }

  public Name getName(){
    return name;
  }

  public boolean isDealer(){
    return false;
  }

  public void addCard(Card card){
    cards.add(card);
  }

  public String getRevenueInfo(){
    return name.getName() + "의 수익: " + revenue.getMoney();
  }

  public void addRevenue(Money revenue){
    double addMoney = revenue.getMoney();
    this.revenue = new Money(addMoney + this.revenue.getMoney());
  }

  public Money getRevenue(){
    return revenue;
  }

  public int getCardScore(){
    return cards.getScore();
  }

  @Override
  public String getCardInfo() {
    return name.getName() + "가 가지고 있는 카드: " + cards.getCardListInfo();
  }

  @Override
  public Cards getCardList(){
    return cards;
  }

  @Override
  public void setCards(Cards cards){
    this.cards = cards;
  }
}
