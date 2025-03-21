package blackjack;

import backjack.utils.Cards.Card;
import backjack.utils.Cards.CardScoreCalculator;
import backjack.utils.Cards.Diamonds;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CardScoreCalcualtorTest {
  private static final CardScoreCalculator cardScoreCalcualtor = new CardScoreCalculator();

  @Test
  @DisplayName("하나의 카드 객체를 주었을 때 올바르게 점수를 반환해주는지")
  void 올바르게_카드의_점수를_반환하는가(){
    Card card = new Diamonds(11);
    assertThat(cardScoreCalcualtor.getCardScore(card)).isEqualTo(10);
  }

  @Test
  @DisplayName("에이스가 포함된 카드리스트가 주어졌을 때 에이스 1또는 11을 21에 가깝게 더 하는가")
  void 에이스가_주어졌을_때_21에_가깝게_더하는가(){
    Card card1 = new Diamonds(11);
    Card card2 = new Diamonds(11);
    Card card3 = new Diamonds(11);
    Card card5 = new Diamonds(1);

    List<Card> cardList = Arrays.asList(card1, card2, card3, card5);
    assertThat(cardScoreCalcualtor.getCardsScore(cardList)).isEqualTo(31);
  }
}
