package backjack.Model;

import backjack.View.OutputView;
import backjack.utils.Referee.Referee;


public class Dealer extends Participant {

  public static final int TWO = 2;

  public Dealer(){
    super(new Name("딜러"));
  }

  @Override
  public void takeDrawing(Deck deck){
    while (Referee.isLessThan17(this)){
      OutputView.annouceDealerAddExtraCard();
      getCardList().add(deck.draw());
    }
  }

  @Override
  public void initialSetting(Deck deck){
    for (int i = 0; i < TWO; i++){
      this.addCard(deck.draw());
    }
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

  @Override
  public boolean isDealer(){
    return true;
  }

}
