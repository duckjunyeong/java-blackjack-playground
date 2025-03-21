package backjack.utils.Cards;

public class Spades extends AbstractCard {
  private static final String TYPE_NAME = "Spades";

  public Spades(int num) {
    super(CardType.SPADES.getType(), num);
  }
}
