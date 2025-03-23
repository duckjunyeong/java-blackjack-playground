package backjack.utils.Cards;
import java.util.List;
import java.util.stream.Collectors;

public class CardScoreCalculator {

  public static int getCardsScore(List<Card> cardList){
    int score = calculateScore(cardList);
    int aceCardCnt = getAceCardCnt(cardList);

    while (aceCardCnt > 0 && score + 10 <= 21){
      score += 10;
      --aceCardCnt;
    }

    return score;
  }

  private static Integer calculateScore(List<Card> cardList) {
    return cardList.stream()
        .map((card) -> card.getScore())
        .reduce(0, (x, y) -> x + y);
  }

  private static int getAceCardCnt(List<Card> cardList) {
    return cardList.stream().filter(card -> card.getRank() == Rank.ACE).collect(Collectors.toList()).size();
  }
}
