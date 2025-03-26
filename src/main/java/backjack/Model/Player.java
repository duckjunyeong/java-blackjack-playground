package backjack.Model;

import backjack.View.InputView;
import backjack.utils.Referee.Referee;
import backjack.View.OutputView;

public class Player extends Participant {
  public static final int TWO = 2;
  private Money dividends;

  public Player(Name name, Money dividends){
    super(name);
    this.dividends = dividends;
  }

  public Player(Name name){
    super(name);
    this.dividends = new Money(0);
  }

  public Money getDividends(){
    return dividends;
  }

  public void setDividends(Money dividends){
    this.dividends = dividends;
  }

  @Override
  public void takeDrawing(Deck deck){
    while(!Referee.isPlayerBust(this) && InputView.readAnswerForExtraCard(this)){
      getCardList().add(deck.draw());
      OutputView.participantCardInfo(this);
    }
    if (Referee.isPlayerBust(this)) OutputView.annoucementBust(this);
  }

  @Override
  public void initialSetting(Deck deck){
    Money bettingMoney = InputView.readBettingAmount(this);
    this.setDividends(bettingMoney);

    for (int i = 0; i < TWO; i++){
      this.addCard(deck.draw());
    }
  }

  @Override
  public String getCardAllInfo(){
    return getCardInfo();
  }

  @Override
  public int getTurnOrder(){
    return 2;
  }
}
