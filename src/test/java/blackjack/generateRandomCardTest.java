package blackjack;

import backjack.Model.Deck;
import backjack.utils.Cards.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class generateRandomCardTest {

  @Test
  @DisplayName("클로버, 다이아, 하트, 스페이드중 ACE~King중에서 하나의 랜덤한 Card를 뽑아내는지 확인한다.")
  void is_Generate_Random_Card(){
    Deck deck = new Deck();
    deck.shuffle();
    Card card = deck.draw();
    System.out.println(card.getCardInfo());
  }
}
