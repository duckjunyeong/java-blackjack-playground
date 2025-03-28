package backjack.utils.Cards;

public enum Rank implements CardInfo {
  ACE("A", 1),
  ONE("1", 1), TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5),
  SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9), TEN("10", 10),
  KING("k", 10), QUEEN("Q", 10), JACK("J", 10);

  private String rank;
  private int score;

  Rank(String rank, int score){
    this.rank = rank;
    this.score = score;
  }

  public String getRank(){
    return rank;
  }

  public int getScore(){
    return this.score;
  }

  @Override
  public String getInfo() {
    return rank;
  }
}
