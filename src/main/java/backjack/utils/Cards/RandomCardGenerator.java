package backjack.utils.Cards;

import backjack.utils.RandomNumGenerator.RandomNumGenerator;

public class RandomCardGenerator {

  public static Card generateRandomCard() {
    return new Card(getRandomElement(Suit.values()), getRandomElement(Rank.values()));
  }

  private static <T extends Enum<T>> T getRandomElement(T[] values) {
    return values[RandomNumGenerator.getRandomNumber(0, values.length)];
  }
}
