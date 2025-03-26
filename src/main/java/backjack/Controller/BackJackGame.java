package backjack.Controller;
import backjack.Model.*;
import backjack.View.InputView;
import backjack.View.OutputView;
import backjack.utils.Cards.CardScoreCalculator;
import backjack.utils.PayoutCalculator.PayoutCalcualtor;
import backjack.utils.Referee.Referee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BackJackGame {

  private static final InputView inputView = new InputView();
  private static final OutputView outputView = new OutputView();

  public void playGame(){
    List<Player> playerList = inputView.readPlayers();
    Dealer dealer = new Dealer();
    round(playerList, dealer);
  }

  public void round(List<Player> humanPlayer, Dealer dealer){

    List<Participant> participants = assembleToParticipants(dealer, humanPlayer);
    Deck deck = new Deck();
    deck.shuffle();

    defaultSetting(participants, deck);
    showParticipantsCards(participants);

    decideDrawAndStand(participants, deck);

    List<Participant> nonDealerParticipant = nonDealerParticipant(participants);
    Referee.determineGameResult(dealer, nonDealerParticipant);

    showGameResultAndRevenue(participants);
  }

  private void decideDrawAndStand(List<Participant> participants, Deck deck) {
    for (Participant participant : participants){
      participant.takeDrawing(deck);
    }
  }

  private void defaultSetting(List<Participant> participants, Deck deck) {
    for (Participant participant : participants){
      participant.initialSetting(deck);
    }
  }

  private List<Participant> assembleToParticipants(Dealer dealer, List<Player> playerList) {
    List<Participant> participants = new ArrayList<>();
    participants.add(dealer);
    participants.addAll(playerList);
    participants.sort(Comparator.comparingInt(Participant::getTurnOrder));

    return participants;
  }

  private void showGameResultAndRevenue(List<Participant> participants) {
    outputView.participantResultInfo(participants);
    outputView.participantRevenueInfo(participants);
  }

  private List<Participant> nonDealerParticipant(List<Participant> participants) {
    return participants.stream()
        .filter(participant -> !participant.isDealer() )
        .collect(Collectors.toList());
  }

  private static void showParticipantsCards(List<Participant> participants) {
    outputView.allHandsOfParticipant(participants);
  }
}
