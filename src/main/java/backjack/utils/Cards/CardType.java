package backjack.utils.Cards;

public enum CardType {
  DIAMONDS("Diamonds"),CLUBS("Clubs"),HEARTS("Hearts"),SPADES("Spades");

  private String type;

  CardType(String type){
    this.type = type;
  }

  public String getType(){
    return type;
  }

}
