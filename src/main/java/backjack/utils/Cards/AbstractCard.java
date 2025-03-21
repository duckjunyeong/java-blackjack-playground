package backjack.utils.Cards;

public abstract class AbstractCard implements Card {
  private String suit;
  private String rank;

  public AbstractCard(String suit, int num){
    this.suit = suit;
    this.rank = TranslatorToRank.numberToRank(num);
  }

  @Override
  public String getCardInfo(){
    return rank + suit;
  }

  @Override
  public String getSuit(){
    return suit;
  }

  @Override
  public String getRank(){
    return rank;
  }
}
