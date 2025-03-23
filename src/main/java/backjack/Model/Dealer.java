package backjack.Model;

import backjack.utils.Cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
  private final List<Card> cardList = new ArrayList<>();

  public List<Card> getCardList(){
    return cardList;
  }
}
