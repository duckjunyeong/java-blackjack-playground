package backjack.utils.Cards;

public class Hearts extends AbstractCard {
  private static final String TYPE_NAME = "Hearts";

  public Hearts(int num) {
    super(CardType.HEARTS.getType(), num);
  }
}
