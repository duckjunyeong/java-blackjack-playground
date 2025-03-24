package blackjack;

import backjack.Model.*;
import backjack.View.OutputView;
import backjack.utils.Referee.Referee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RefereeTest {
  private final static OutputView outputView = new OutputView();
  private Deck deck;
  private Dealer dealer;

  @BeforeEach
  void setUp(){
    deck = new Deck();
    deck.shuffle();
    dealer = new Dealer();
  }

  @Test
  @DisplayName("dealer와 participant가 주어졌을 때 승패를 가려 각자의 수익을 올바르게 판단하는가")
  void dealer와_participant의_승패를_올바르게_판단하는가(){

    List<Player> playerList = enrollPlayer(Arrays.asList(new Name("jun"), new Name("kim"), new Name("han")), Arrays.asList(new Money(2000), new Money(5000), new Money(9000)));
    enrollInitialCards(playerList);

    getResult(playerList);

    printResult(playerList);
  }

  private void printResult(List<Player> playerList) {
    List<Participant> participants = new ArrayList<>();
    participants.add(dealer);
    participants.addAll(playerList);
    outputView.participantCardInfo(participants);
    outputView.participantRevenueInfo(participants);
  }

  private void getResult(List<Player> playerList) {
    playerList.forEach(player -> Referee.determineVictory(dealer, player));
  }

  private void enrollInitialCards(List<Player> playerList) {
    dealer.setCards(new Cards(Arrays.asList(deck.draw(), deck.draw())));
    playerList.forEach(player -> player.setCards(new Cards(Arrays.asList(deck.draw(), deck.draw()))));

  }

  List<Player> enrollPlayer(List<Name> names, List<Money> bettingAmount){
    List<Player> playerList = names.stream()
        .map(Player::new)
        .collect(Collectors.toList());

    for (int i = 0; i < playerList.size(); i++){
      playerList.get(i).setDividends(bettingAmount.get(i));
    }
    return playerList;
  }
}
