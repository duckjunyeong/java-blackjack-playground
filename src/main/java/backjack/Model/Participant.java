package backjack.Model;

import backjack.utils.Cards.Card;

public abstract class Participant implements HandHolder {
  private Cards cards;
  private Name name;

  public Participant(Name name){
    this.name = name;
    this.cards = new Cards();
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

  @Override
  public String getMyCardInfo() {
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
