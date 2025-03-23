package backjack.utils.Cards;

public class RandomCardGenerator {

  public static Card generateRandomCard() {
  //  return new Card(getRandomElement(Suit.values()), getRandomElement(Suit.values()));
    // 이렇게 되면 Card내의 멤버변수의 타입도 변경해야하네 --> 음....
    return new Card(Suit.DIAMONDS, Rank.ACE);
  }

  private static CardInfo getRandomElement(CardInfo[] cardInfo) {
    return cardInfo[2];
  }
}
