package blackjack;

import backjack.Controller.BackJackGame;
import backjack.Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class BackJackGameTest {
  private BackJackGame backJackGame;
  private Deck deck;
  private Dealer dealer;

  @BeforeEach
  void 컨트롤러_테스트를위한_기본객체생성(){
    this.backJackGame = new BackJackGame();
    this.deck = new Deck();
    this.dealer = new Dealer();
  }

  @Test
  @DisplayName("각 플레이어 및 딜러에게 2개의 카드를 랜덤으로 분배하고 현재 가지고 있는 카드 정보를 출력하는가")
  void 플레이어및딜러에게_2개의_카드를_분배하고_카드정보를_출력하는가(){
    Player jun = new Player(new Name("jun"));
    Player han = new Player(new Name("han"));
    Player kim = new Player(new Name("kim"));
    List<Participant> participants = Arrays.asList(jun, han, kim, dealer);

    backJackGame.initDraw(participants, deck);
    List<String> infoList = getPlayersCardInfo(participants);

    for (String info : infoList){
      System.out.println(info);
    }
  }

  private static List<String> getPlayersCardInfo(List<Participant> playerList) {
    return playerList.stream()
        .map(player -> player.getMyCardInfo()).collect(Collectors.toList());
  }

}
