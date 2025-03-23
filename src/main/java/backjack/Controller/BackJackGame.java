package backjack.Controller;

import backjack.Model.Dealer;
import backjack.Model.Player;

import java.util.List;

public class BackJackGame {

  public void playGame(){
    // 사용자를 입력받는다.
    // 딜러를 생성한다.
    // 해당 사용자를 가지고 round를 진행한다.
  }

  public void round(List<Player> players, Dealer dealer){
    // players을 순회하면서 베팅액을 받고 Money객체를 생성한다.
    // 딜러 및 플레이어들에게 2장씩 카드를 나눠준다. ( void initDraw())
  }


  public void initDraw(List<Player> players, Dealer dealer){
    // players을 순회한다. 카드 2장을 뽑고 ( Deck.draw() * 2 ) 해당 리스트를  이용해 Cards 객체를 생성한다. 해당 객체를 player들마다 넣어준다.
  }
}
