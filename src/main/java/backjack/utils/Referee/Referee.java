package backjack.utils.Referee;
import backjack.Model.Dealer;
import backjack.Model.Money;
import backjack.Model.Player;

public class Referee {

  public static final int BLACKJACK_SCORE = -1;

  public static void determineVictory(Dealer dealer, Player player) {
    int dealerScore = dealer.getCardScore();
    int playerScore = player.getCardScore();

    if (isDraw(dealerScore, playerScore)) return;

    if (isOnlyPlayerBackJack(dealerScore, playerScore)) {
      playerWinFromBackJack(dealer, player);
      return;
    }

    if (isOnlyDealerBackJack(dealerScore, playerScore)){
      dealerWinFromBackJack(dealer, player);
      return;
    }

    if (isBiggerThanDealer(dealerScore, playerScore)){
      playerWinFromScore(dealer, player);
      return;
    }
    dealerWinFromScore(dealer, player);
  }

  private static void dealerWinFromBackJack(Dealer dealer, Player player) {
    player.addRevenue(new Money(player.getDividends().getMoney() * -1));
    dealer.addRevenue(new Money(player.getDividends().getMoney()));
  }

  private static boolean isOnlyDealerBackJack(int dealerScore, int playerScore) {
    return dealerScore == BLACKJACK_SCORE && playerScore != BLACKJACK_SCORE;
  }

  private static void dealerWinFromScore(Dealer dealer, Player player) {
    player.addRevenue(new Money(player.getDividends().getMoney() * -1));
    dealer.addRevenue(new Money(player.getDividends().getMoney()));
  }

  private static void playerWinFromScore(Dealer dealer, Player player) {
    player.addRevenue(new Money(player.getDividends().getMoney()));
    dealer.addRevenue(new Money(player.getDividends().getMoney() * -1));
  }

  public static void playerWinFromBackJack(Dealer dealer, Player player){
    player.addRevenue(new Money(player.getDividends().getMoney() * 1.5));
    dealer.addRevenue(new Money(player.getDividends().getMoney() * -1.5));
  }

  private static boolean isOnlyPlayerBackJack(int dealerScore, int playerScore) {
    return dealerScore != BLACKJACK_SCORE && playerScore == BLACKJACK_SCORE;
  }

  private static boolean isDraw(int dealerScore, int playerScore) {
    return dealerScore == playerScore;
  }

  private static boolean isBiggerThanDealer(int dealerScore, int playerScore) {
    return dealerScore < playerScore;
  }

}
