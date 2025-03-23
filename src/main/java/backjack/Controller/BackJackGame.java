package backjack.Controller;
import backjack.Model.*;
import java.util.List;

public class BackJackGame {

  public static final int INITIAL_DEAL_COUNT = 2;

  public void playGame(){
    // 사용자를 입력받는다.
    // 딜러를 생성한다.
    // 해당 사용자를 가지고 round를 진행한다.
  }

  public void round(List<Player> players, Dealer dealer){
    // players을 순회하면서 베팅액을 받고 Money객체를 생성한다.
    // deck을 생성하고 섞는다.
    // 딜러 및 플레이어들에게 2장씩 카드를 나눠준다. ( void initDraw())
  }

  public void initDraw(List<Participant> participants, Deck deck){
    for (Participant participant : participants){
      dealCard(deck, participant);
    }
  }

  private static void dealCard(Deck deck, Participant participant) {
    for (int i = 0; i < INITIAL_DEAL_COUNT; i++){
      participant.addCard(deck.draw());
    }
  }
}
