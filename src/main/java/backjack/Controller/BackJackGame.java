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

  public static final int TWO = 2;
  public static final int BUST_SCORE = 22;

  public void playGame(){
    List<Player> playerList = inputView.readPlayers();
    Dealer dealer = new Dealer();
    round(playerList, dealer);
  }

  public void round(List<Player> humanPlayer, Dealer dealer){

    List<Participant> participants = assembleToParticipants(dealer, humanPlayer);
    Deck deck = new Deck();
    deck.shuffle();

    // 리팩토링 한 번 봐야함 !!!!
    defaultSetting(playerList, dealer, deck);
    showParticipantsCards(participants);

    decideDrawAndStand(playerList, dealer, deck);

    // 게임의 결과를 도출하는 상황
    List<Participant> Participant= getNonBustedParticipants(participants);
    Referee.determineGameResult(dealer, participants);

    showGameResultAndRevenue(participants);
  }

  // 리팩토링: dealer와 Player 다형성으로 똑같이 만들어서 각자 다른 메서드로 구현하기
  private void decideDrawAndStand(List<Player> playerList, Dealer dealer, Deck deck) {
    askToPlayersAddCard(playerList, dealer, deck);
    dealerDrawUtil17(dealer, deck);
  }

  // 리팩토링: 오버라이딩해서 같은 메서드를 만들게 해야하나??
  private void defaultSetting(List<Player> playerList, Dealer dealer, Deck deck) {
    inputView.readBettingAmount(playerList);
    dealInitialCards(dealer, playerList, deck);
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

  private List<Participant> getNonBustedParticipants(List<Participant> participants) {
    return participants.stream()
        .filter(participant -> CardScoreCalculator.getCardsScore(participant.getCardList().getCardList()) < BUST_SCORE)
        .collect(Collectors.toList());
  }

  private void dealerDrawUtil17(Dealer dealer, Deck deck) {
    while (Referee.isLessThan17(dealer)){
      outputView.annouceDealerAddExtraCard();
      draw(dealer, deck);
    }
  }

  private static void showParticipantsCards(List<Participant> participants) {
    outputView.allHandsOfParticipant(participants);
  }

  private void askToPlayersAddCard(List<Player> playerList, Dealer dealer, Deck deck) {
    for (Player player : playerList){
      askToPlayerAddCard(dealer, deck, player);
    }
  }

  private void askToPlayerAddCard(Dealer dealer, Deck deck, Player player) {
    while(!Referee.isPlayerBust(player) && askForAdditionalCard(player)){
      addOneCard(player, deck);
      showOneHand(player);
    }
    if (Referee.isPlayerBust(player)) checkForPlayerBust(dealer, player);
  }

  private static boolean askForAdditionalCard(Player player) {
    String answer = inputView.readExtraAddCard(player);
    return answer.equals("y");
  }

  private static void showOneHand(Player player) {
    outputView.participantCardInfo(player);
  }

  private void addOneCard(Player player, Deck deck) {
    draw(player, deck);
  }

  private static void checkForPlayerBust(Dealer dealer, Player player) {
    if (Referee.isPlayerBust(player)) {
      outputView.annoucementBust(player);
      PayoutCalcualtor.payoutOnPlayerBust(player, dealer);
    }
  }

  private void dealInitialCards(Dealer dealer, List<Player> playerList, Deck deck){
    dealTwoCards(dealer, deck);
    for (Player player : playerList){
      dealTwoCards(player, deck);
    }
  }

  private void dealTwoCards(Participant participant, Deck deck) {
    for (int i = 0; i < TWO; i++){
      participant.addCard(deck.draw());
    }
  }

  private void draw(Participant participant, Deck deck){
    participant.addCard(deck.draw());
  }
}
