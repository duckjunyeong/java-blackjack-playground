package backjack.utils.Referee;
import backjack.Model.Dealer;
import backjack.Model.Participant;
import backjack.Model.Player;
import backjack.utils.Cards.CardScoreCalculator;
import backjack.utils.PayoutCalculator.PayoutCalcualtor;

import java.util.List;

public class Referee {

  public static final int BLACKJACK_SCORE = 21;
  public static final int BUST_SCORE = 22;
  public static final int MINIMUM_DEALER_SCORE = 17;

  public static void determineGameResult(Dealer dealer, List<Participant> participants){
    for (Participant participant : participants){
      PayoutCalcualtor.calculatePayout(dealer, participant, Referee.determineVictory(dealer, participant));
    }
  }

  // CardScoreCalculator 위임
  public static BlackJackResult determineVictory(Dealer dealer, Participant participant) {
    int dealerScore = CardScoreCalculator.getCardsScore(dealer.getCardList().getCardList());
    int playerScore = CardScoreCalculator.getCardsScore(participant.getCardList().getCardList());

    if (playerScore > 21) return BlackJackResult.PLAYER_LOSE;
    if (dealerScore > 21) return BlackJackResult.PLAYER_WIN;

    if (isDraw(dealerScore, playerScore)) return BlackJackResult.DRAW;

    if (isOnlyPlayerBackJack(dealerScore, playerScore)) return BlackJackResult.PLAYER_BLACKJACK_WIN;

    if (isPlayerWin(dealerScore, playerScore)) return BlackJackResult.PLAYER_WIN;

    return BlackJackResult.PLAYER_LOSE;
  }

  public static boolean isPlayerBust(Player player){
    return player.getCardScore() >= BUST_SCORE;
  }

  public static boolean isDealerBust(Dealer dealer) {
    return dealer.getCardScore() >= BUST_SCORE;
  }

  public static boolean isLessThan17(Dealer dealer) {
    return CardScoreCalculator.getCardsScore(dealer.getCardList().getCardList()) < MINIMUM_DEALER_SCORE;
  }

  private static boolean isOnlyPlayerBackJack(int dealerScore, int playerScore) {
    return dealerScore != BLACKJACK_SCORE && playerScore == BLACKJACK_SCORE;
  }

  private static boolean isDraw(int dealerScore, int playerScore) {
    return dealerScore == playerScore;
  }

  private static boolean isPlayerWin(int dealerScore, int playerScore) {
    return dealerScore < playerScore;
  }

}
