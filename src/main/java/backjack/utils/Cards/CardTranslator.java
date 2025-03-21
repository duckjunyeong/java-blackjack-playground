package backjack.utils.Cards;

public class CardTranslator {

  public static String numberToString(int num){
    if (num == 1) return  "A";
    if (num == 11) return "J";
    if (num == 12) return "K";
    if (num == 13) return "Q";
    return String.valueOf(num);
  }
}
