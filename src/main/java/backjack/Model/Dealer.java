package backjack.Model;


import backjack.utils.Cards.Card;
import nextstep.fp.Car;

import java.util.List;

public class Dealer {
  private Cards cards;
  private Name name;

  public Dealer(){
    this.cards = new Cards();
    this.name = new Name("딜러");
  }

  public Cards getCardList(){
    return cards;
  }

  public String getMyCardInfo() {
    return name.getName() + "가 가지고 있는 카드: " + cards.getCardListInfo();
  }

  public void setCards(Cards cards) {
    this.cards = cards;
  }
}
