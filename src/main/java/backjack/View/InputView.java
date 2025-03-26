package backjack.View;

import backjack.Model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);
  public static final String NOT_ZERO_BETTING_AMOUNT = "0이하의 금액은 배팅할 수 없습니다.";
  public static final String ANSEWR_IS_Y_OR_N = "your answer should be y or n";

  public static boolean readAnswerForExtraCard(Participant participant) {
    System.out.println(participant.getName().getName() + " Extra Add Card??");
    String answer = scanner.nextLine();
    isValidAnswer(answer);
    return answer.equals("y");
  }

  public List<Player> readPlayers() {
    System.out.println("Write players");
    String players = scanner.nextLine();
    return Arrays.stream(players.split(","))
        .map(Name::new)
        .map(Player::new)
        .collect(Collectors.toList());
  }

  // dealer와 Player각각 메서드를 오버라이딩해서 할 수 있나?? dealer는 아무것도 안 하게 만들고... 부자들은 얼마이상의 돈만 배팅할 수 있게 하고,,
  public static Money readBettingAmount(Participant participant) {
    System.out.println(participant.getName().getName() + " of Betting Amounts");
    String bettingAmounts = scanner.nextLine();
    isValidBettingAmounts(bettingAmounts);
    return new Money(bettingAmounts);
  }

  private static void isValidBettingAmounts(String bettingAmounts) {
    if (Integer.parseInt(bettingAmounts) < 0) throw new IllegalArgumentException(NOT_ZERO_BETTING_AMOUNT);
  }

  public String readExtraAddCard(Player player) {
    System.out.println(player.getName().getName() + " Extra Add Card??");
    String answer = scanner.nextLine();
    isValidAnswer(answer);
    return answer;
  }

  private static void isValidAnswer(String answer) {
    if (!answer.equals("y") && !answer.equals("n")) throw new IllegalArgumentException(ANSEWR_IS_Y_OR_N);
  }
}
