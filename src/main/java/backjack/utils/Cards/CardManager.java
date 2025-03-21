package backjack.utils.Cards;

import backjack.utils.RandomGenerator.RandomGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CardManager {
  private final static Map<Integer, Function<Integer, Card>> cardCreatorFrame = new HashMap<>();
  private final static int START_CARD_TYPE = 0;
  private final static int END_CARD_TYPE = 4;
  private final static int START_CARD_NUM = 1;
  private final static int END_CARD_NUM = 13;

  static {
    cardCreatorFrame.put(0, Clubs::new);
    cardCreatorFrame.put(1, Diamonds::new);
    cardCreatorFrame.put(2, Hearts::new);
    cardCreatorFrame.put(3, Spades::new);
  }

  public static Card generateRandomCard() {
    int cardType = RandomGenerator.getRandomNumber(START_CARD_TYPE, END_CARD_TYPE);
    int cardNum = RandomGenerator.getRandomNumber(START_CARD_NUM, END_CARD_NUM);

    return cardCreatorFrame.get(cardType).apply(cardNum);
  }
}
