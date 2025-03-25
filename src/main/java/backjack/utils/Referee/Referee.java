package backjack.utils.Referee;
import backjack.Model.Dealer;
import backjack.Model.Player;

public class Referee {

  public static final int BLACKJACK_SCORE = 21;
  public static final int BUST_SCORE = -1;

  public static BlackJackResult determineVictory(Dealer dealer, Player player) {
    int dealerScore = dealer.getCardScore();
    int playerScore = player.getCardScore();

    if (isDraw(dealerScore, playerScore)) return BlackJackResult.DRAW;

    if (isOnlyPlayerBackJack(dealerScore, playerScore)) return BlackJackResult.PLAYER_BLACKJACK_WIN;

    if (isPlayerWin(dealerScore, playerScore)) return BlackJackResult.PLAYER_WIN;

    return BlackJackResult.PLAYER_LOSE;
  }

  public static boolean isPlayerBust(Player player){
    return player.getCardScore() == BUST_SCORE;
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

  public static boolean isDealerBust(Dealer dealer) {
    return dealer.getCardScore() == BUST_SCORE;
  }
}
