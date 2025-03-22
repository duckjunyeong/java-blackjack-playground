package backjack.utils.Cards;
import java.util.List;
import java.util.stream.Collectors;

public class CardScoreCalculator {
  public static final int HIGHEST_SCORE = 21;
  public static final int ACE_HIGHER_SCORE = 11;
  public static final int ACE_LOWER_SCORE = 1;

  public static int getCardScore(Card card) {
    return card.getScore();
  }

  public static int getCardsScore(List<Card> cardList) {
    List<Card> aceCardList = getAceCards(cardList);

    int cardScoreSum = getSumExceptAceCard(cardList);

    cardScoreSum = addAceCardScore(aceCardList, cardScoreSum);
    return cardScoreSum;
  }

  private static int addAceCardScore(List<Card> aceCardList, int cardScoreSum) {
    for (int i = 0; i < aceCardList.size(); i++){
      if (isAddEleven(cardScoreSum)) {
        cardScoreSum += ACE_HIGHER_SCORE;
        continue;
      }
      cardScoreSum += ACE_LOWER_SCORE;
    }
    return cardScoreSum;
  }

  private static Integer getSumExceptAceCard(List<Card> cardList) {
    return cardList.stream()
        .filter(card -> !isAceCard(card))
        .map(CardScoreCalculator::getCardScore)
        .reduce(0, (x, y) -> x + y);
  }

  private static List<Card> getAceCards(List<Card> cardList) {
    return cardList.stream()
        .filter(card -> isAceCard(card))
        .collect(Collectors.toList());
  }

  private static boolean isAceCard(Card card) {
    return card.getRank().equals(Rank.ACE);
  }
  
  private static boolean isAddEleven(int cardScore) {
    return HIGHEST_SCORE - cardScore >= 11;
  }
}
