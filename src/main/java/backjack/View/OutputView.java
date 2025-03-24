package backjack.View;

import backjack.Model.Participant;

import java.util.List;

public class OutputView {
  public void participantRevenueInfo(List<Participant> participants) {
    for (Participant participant : participants){
      System.out.println(participant.getRevenueInfo());
    }
  }

  public void participantCardInfo(List<Participant> participants) {
    for (Participant participant : participants){
      System.out.println(participant.getCardInfo());
    }
  }
}
