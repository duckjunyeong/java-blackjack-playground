package backjack.utils.Cards;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardScoreCalculator {
  public static final int HIGHEST_SCORE = 21;
  public static final int  ACE_HIGHER_SCORE = 11;
  public static final int ACE_LOWER_SCORE = 1;
  public static final int FACECARD_SCORE = 10;
  public static final String ACE_NUMBER = "A";

  private static final List<String> faceCards = Arrays.asList("K", "Q", "J");
  public static final String NOT_ALLOW_ACE_CARD = "A number isn't determine";

  public static int getCardScore(Card card) {
    if (isAceCard(card)) throw new IllegalArgumentException(NOT_ALLOW_ACE_CARD);

    if (faceCards.contains(card.getRank())) return FACECARD_SCORE;

    return Integer.parseInt(card.getRank());
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
    return card.getRank().equals(ACE_NUMBER);
  }
  
  private static boolean isAddEleven(int cardScore) {
    return HIGHEST_SCORE - cardScore >= 11;
  }
}
