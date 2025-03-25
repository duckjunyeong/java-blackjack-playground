package backjack.Model;

public class Dealer extends Participant {

  public Dealer(){
    super(new Name("딜러"));
  }

  @Override
  public String getCardInfo(){
    return getName().getName() + "가 가지고 있는 카드: " + getCardList().getOnlyOneCardInfo();
  }

  @Override
  public String getCardAllInfo(){
    return getName().getName() + "가 가지고 있는 카드: " + getCardList().getCardListInfo();
  }

  @Override
  public int getTurnOrder(){
    return 1;
  }

}
