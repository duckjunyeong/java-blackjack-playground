package backjack.utils.Cards;

public class Card {
  private Suit suit;
  private Rank rank;

  public Card(Suit suit, Rank rank){
    this.suit = suit;
    this.rank = rank;
  }

  public String getCardInfo(){
    return rank.getInfo() + suit.getInfo();
  }

  public int getScore(){
    return rank.getScore();
  }

  public Suit getSuit(){
    return suit;
  }

  public Rank getRank(){
    return rank;
  }
}
