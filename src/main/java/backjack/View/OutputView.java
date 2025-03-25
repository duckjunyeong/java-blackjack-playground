package backjack.View;

import backjack.Model.Dealer;
import backjack.Model.Participant;
import backjack.Model.Player;
import backjack.utils.Cards.CardScoreCalculator;

import java.util.List;

public class OutputView {

  public static final String ANNOUCEMENT_BUST = "Bust!!!!";

  public void participantRevenueInfo(List<Participant> participants) {
    for (Participant participant : participants){
      System.out.println(participant.getRevenueInfo());
    }
  }

  public void allHandsOfPlayer(List<Player> playerList){
    for (Player player : playerList){
      System.out.println(player.getCardInfo());
    }
  }

  public void allHandsOfDealer(Dealer dealer){
    System.out.println(dealer.getOnlyOneCardInfo());
  }

  public void participantCardInfo(Participant participant) {
    System.out.println(participant.getCardInfo());
  }

  public void participantResultInfo(List<Participant> participants) {
    for (Participant participant : participants){
      printGameResult(participant);
    }
  }

  public void annoucementBust(Participant player) {
    System.out.println(ANNOUCEMENT_BUST);
  }

  public void annouceDealerAddExtraCard() {
    System.out.println("dealer is score 16, so add extra card");
  }


  private static void printGameResult(Participant participant) {
    System.out.println(participant.getCardAllInfo() + "- 결과: " + CardScoreCalculator.getCardsScore(participant.getCardList().getCardList()));
  }

  public void allHandsOfParticipant(List<Participant> participants) {
    for (Participant participant : participants){
      System.out.println(participant.getCardInfo());
    }
  }
}
