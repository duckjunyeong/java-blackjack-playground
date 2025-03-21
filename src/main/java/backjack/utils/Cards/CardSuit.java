package backjack.utils.Cards;

public enum CardSuit {
  DIAMONDS("Diamonds"),CLUBS("Clubs"),HEARTS("Hearts"),SPADES("Spades");

  private String type;

  CardSuit(String type){
    this.type = type;
  }

  public String getType(){
    return type;
  }

}
