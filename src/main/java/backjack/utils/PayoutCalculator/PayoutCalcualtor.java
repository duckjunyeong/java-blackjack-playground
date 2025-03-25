package backjack.utils.PayoutCalculator;

import backjack.Model.Dealer;
import backjack.Model.Money;
import backjack.Model.Player;
import backjack.utils.Referee.BlackJackResult;

import java.util.List;
import java.util.stream.Collectors;

public class PayoutCalcualtor {

  public static final double BLACKJACK_SCORE = 21;

  public static void calculatePayout(Dealer dealer, Player player, BlackJackResult blackJackResult) {
    double playerProfit = player.getDividends().getMoney() * blackJackResult.getMultiplier();
    player.addRevenue(new Money(playerProfit));
    dealer.addRevenue(new Money(playerProfit * -1));
  }

  public static void payoutOnDealerBust(Dealer dealer, List<Player> playerList) {
      payoutToBackJackPlayers(dealer, getBlackJackPlayers(playerList));
      payoutToPlayers(dealer, getExceptionBlackJackPlayers(playerList));
  }

  private static void payoutToPlayers(Dealer dealer, List<Player> exceptionBlackJackPlayers) {
    exceptionBlackJackPlayers.stream()
        .forEach(player -> calculatePayout(dealer, player, BlackJackResult.PLAYER_WIN));
  }

  private static void payoutToBackJackPlayers(Dealer dealer, List<Player> blackJackPlayers) {
      blackJackPlayers.stream()
          .forEach(player -> calculatePayout(dealer, player, BlackJackResult.PLAYER_BLACKJACK_WIN));
  }

  private static List<Player> getExceptionBlackJackPlayers(List<Player> playerList) {
    return playerList.stream()
        .filter(player -> player.getCardScore() != BLACKJACK_SCORE)
        .collect(Collectors.toList());
  }

  private static List<Player> getBlackJackPlayers(List<Player> playerList) {
    return playerList.stream()
        .filter(player -> player.getCardScore() == BLACKJACK_SCORE)
        .collect(Collectors.toList());
  }
}
