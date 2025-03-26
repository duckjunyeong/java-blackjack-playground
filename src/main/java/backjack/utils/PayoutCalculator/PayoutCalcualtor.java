package backjack.utils.PayoutCalculator;

import backjack.Model.Dealer;
import backjack.Model.Money;
import backjack.Model.Participant;
import backjack.utils.Referee.BlackJackResult;

import java.util.List;
import java.util.stream.Collectors;

public class PayoutCalcualtor {

  public static final double BLACKJACK_SCORE = 21;

  public static void calculatePayout(Dealer dealer, Participant participant, BlackJackResult blackJackResult) {
    double playerProfit = participant.getDividends().getMoney() * blackJackResult.getMultiplier();
    participant.addRevenue(new Money(playerProfit));
    dealer.addRevenue(new Money(playerProfit * -1));
  }

  public static void payoutOnDealerBust(Dealer dealer, List<Participant> participants) {
    payoutToBackJackParticipants(dealer, getBlackJackPlayersParticipants(participants));
    payoutToPlayers(dealer, getExceptionBlackJackParticipants(participants));
  }

  public static void payoutOnPlayerBust(Participant participant, Dealer dealer) {
    calculatePayout(dealer, participant, BlackJackResult.PLAYER_LOSE);
  }

  private static void payoutToPlayers(Dealer dealer, List<Participant> participants) {
    participants.stream()
        .forEach(participant -> calculatePayout(dealer, participant, BlackJackResult.PLAYER_WIN));
  }

  private static void payoutToBackJackParticipants(Dealer dealer, List<Participant> blackJackParticipants) {
    blackJackParticipants.stream()
          .forEach(participant -> calculatePayout(dealer, participant, BlackJackResult.PLAYER_BLACKJACK_WIN));
  }

  private static List<Participant> getExceptionBlackJackParticipants(List<Participant> playerList) {
    return playerList.stream()
        .filter(participant -> participant.getCardScore() != BLACKJACK_SCORE)
        .collect(Collectors.toList());
  }

  private static List<Participant> getBlackJackPlayersParticipants(List<Participant> playerList) {
    return playerList.stream()
        .filter(participant -> participant.getCardScore() == BLACKJACK_SCORE)
        .collect(Collectors.toList());
  }
}
