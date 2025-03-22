package backjack.utils.Cards;

import java.util.Arrays;
import java.util.List;

public enum Rank implements CardInfo {
  ACE("A"),
  ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"),
  SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
  KING("k"), QUEEN("Q"), JACK("J");

  public static final int FACECARD_SCORE = 10;
  private static final List<Rank> faceCardRanks = Arrays.asList(Rank.KING, Rank.JACK, Rank.QUEEN);
  public static final String NOT_ALLOW_ACE_CARD = "Ace number isn't determine";

  private String rank;

  Rank(String rank){
    this.rank = rank;
  }

  public String getRank(){
    return rank;
  }

  public int getScore(){
    if (isAceCard(this)) throw new IllegalArgumentException(NOT_ALLOW_ACE_CARD);
    if (isFaceCard(this)) return FACECARD_SCORE;

    return Integer.parseInt(this.rank);
  }

  private static boolean isFaceCard(Rank rank) {
    return faceCardRanks.contains(rank);
  }

  private static boolean isAceCard(Rank rank) {
    return rank.equals(ACE);
  }

  @Override
  public String getInfo() {
    return rank;
  }
}
