package backjack.Controller;

import backjack.Model.Cards;
import backjack.Model.Dealer;
import backjack.Model.Deck;
import backjack.Model.Player;
import backjack.utils.Cards.Card;

import java.util.ArrayList;
import java.util.List;

public class BackJackGame {

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


  public void initDraw(List<Player> players, Dealer dealer, Deck deck){
    initDrawPlayers(players, deck);
    initDrawDealer(dealer, deck);
  }

  private static void initDrawDealer(Dealer dealer, Deck deck) {
    List<Card> cardList = new ArrayList<>();
    for (int i = 0; i < 2; i++){
      cardList.add(deck.draw());
    }
    dealer.setCards(new Cards(cardList));
  }

  private static void initDrawPlayers(List<Player> players, Deck deck) {
    for (Player player : players){
      List<Card> cardList = new ArrayList<>();
      for (int i = 0; i < 2; i++){
        cardList.add(deck.draw());
      }
      player.setCards(new Cards(cardList));
    }
  }
}
