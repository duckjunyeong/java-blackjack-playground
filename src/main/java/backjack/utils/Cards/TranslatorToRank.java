package backjack.utils.Cards;

import java.util.HashMap;
import java.util.Map;

public class TranslatorToRank {
  private static final Map<Integer, String> convertNumberToRank = new HashMap<>();

  static {
    convertNumberToRank.put(1, "A");
    convertNumberToRank.put(11, "J");
    convertNumberToRank.put(12, "K");
    convertNumberToRank.put(13, "Q");

    for (int i = 2; i < 10; i++){
      convertNumberToRank.put(i, String.valueOf(i));
    }
  }

  public static String numberToRank(int num){
    return convertNumberToRank.get(num);
  }
}
