package backjack.Model;

import backjack.utils.Cards.Card;
import backjack.utils.Cards.CardScoreCalculator;

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

  public void add(Card card){
    cardList.add(card);
  }

  public List<Card> getCardList(){
    return cardList;
  }

  public String getCardListInfo() {
    return cardList.stream().map(Card::getCardInfo).collect(Collectors.joining(", "));
  }

  public int getScore(){
    int score = CardScoreCalculator.getCardsScore(cardList);

    if (cardList.size() == 2 && score == 21) return -1;
    return score;
  }
}
