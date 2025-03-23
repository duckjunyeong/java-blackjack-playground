package backjack.Model;

import backjack.utils.Cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cards {
  private List<Card> cardList;

  public Cards(List<Card> cardList) {
    this.cardList = cardList;
  }

  public Cards(){
    this.cardList = new ArrayList<>();
  }

  public List<Card> getCardList(){
    return cardList;
  }

  public String getCardListInfo() {
    return cardList.stream().map(Card::getCardInfo).collect(Collectors.joining(", "));
  }
}
