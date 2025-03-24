package blackjack;

import backjack.Model.*;
import backjack.utils.Referee.Referee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RefereeTest {

  @Test
  @DisplayName("dealer와 participant가 주어졌을 때 승패를 가려 각자의 수익을 올바르게 판단하는가")
  void dealer와_participant의_승패를_올바르게_판단하는가(){
    Deck deck = new Deck();
    deck.shuffle();
    Dealer dealer = new Dealer();
    dealer.setCards(new Cards(Arrays.asList(deck.draw(), deck.draw())));
    Player player = new Player(new Name("jun"));
    player.setCards(new Cards(Arrays.asList(deck.draw(), deck.draw())));
    player.setDividends(new Money(2000));

    Player player2 = new Player(new Name("kim"));
    player2.setCards(new Cards(Arrays.asList(deck.draw(), deck.draw())));
    player2.setDividends(new Money(9000));

    Player player3 = new Player(new Name("han"));
    player3.setCards(new Cards(Arrays.asList(deck.draw(), deck.draw())));
    player3.setDividends(new Money(5000));

    System.out.println(dealer.getMyCardInfo());
    System.out.println(player.getMyCardInfo());
    System.out.println(player2.getMyCardInfo());
    System.out.println(player3.getMyCardInfo());
    Referee.determineVictory(dealer, player);
    Referee.determineVictory(dealer, player2);
    Referee.determineVictory(dealer, player3);
    System.out.println(dealer.getMyRevenueInfo());
    System.out.println(player.getMyRevenueInfo());
    System.out.println(player2.getMyRevenueInfo());
    System.out.println(player3.getMyRevenueInfo());
  }
}
