package backjack.utils.Cards;

public enum Suit implements CardInfo {
  DIAMONDS("Diamonds"),CLUBS("Clubs"),HEARTS("Hearts"),SPADES("Spades");

  private String suit;

  Suit(String suit){
    this.suit = suit;
  }

  @Override
  public String getInfo() {
    return suit;
  }
}
