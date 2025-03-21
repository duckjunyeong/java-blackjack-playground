package backjack.utils.Cards;

public abstract class AbstractCard implements Card {
  private String typeName;
  private String number;

  public AbstractCard(String typeName, int num){
    this.typeName = typeName;
    this.number = CardTranslator.numberToString(num);
  }

  @Override
  public String getCardInfo(){
    return number + typeName;
  }

  @Override
  public String getTypeName(){
    return typeName;
  }

  @Override
  public String getNumber(){
    return number;
  }
}
