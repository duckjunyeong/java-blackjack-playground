package blackjack;

import backjack.Model.*;
import backjack.View.OutputView;
import backjack.utils.PayoutCalculator.PayoutCalcualtor;
import backjack.utils.Referee.Referee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    //printResult(playerList);
  }

  @Test
  @DisplayName("Dealer의 점수가 21점을 초과했을 때 나머지 플레이어들에게 배당액을 받는가.")
  void dealer의_점수가_21점을_초과했을_때_배당액을_받는가(){
    List<Participant> playerList = enrollPlayer(Arrays.asList(new Name("jun"), new Name("kim"), new Name("han")), Arrays.asList(new Money(2000), new Money(5000), new Money(9000)));

    enrollInitialCards(playerList);
    for (int i = 0 ; i < 5; i++){
      dealer.addCard(deck.draw());
    }
    if (Referee.isDealerBust(dealer)){
      PayoutCalcualtor.payoutOnDealerBust(dealer, playerList);
    }
  }


//  private void printResult(List<Player> playerList) {
//    outputView.allHandsOfPlayer(playerList);
//    outputView.participantRevenueInfo(playerList);
//  }

  private void getResult(List<Player> playerList) {
    for (Player player: playerList){
      PayoutCalcualtor.calculatePayout(dealer, player, Referee.determineVictory(dealer, player));
    }
  }

  private void enrollInitialCards(List<Participant> participants) {
    dealer.setCards(new Cards(Arrays.asList(deck.draw(), deck.draw())));
    participants.forEach(participant -> participant.setCards(new Cards(Arrays.asList(deck.draw(), deck.draw()))));

  }

  List<Participant> enrollPlayer(List<Name> names, List<Money> bettingAmount){
    List<Participant> participants = names.stream()
        .map(Player::new)
        .collect(Collectors.toList());

    for (int i = 0; i < participants.size(); i++){
      participants.get(i).setDividends(bettingAmount.get(i));
    }
    return participants;
  }
}
