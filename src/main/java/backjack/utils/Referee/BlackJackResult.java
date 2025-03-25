package backjack.utils.Referee;

public enum BlackJackResult {
  PLAYER_WIN(1.0), PLAYER_BLACKJACK_WIN(1.5), DRAW(0), PLAYER_LOSE(-1.0), PLAYER_BUST(-1.0);

  private double multiplier;

  BlackJackResult(double multiplier) {
    this.multiplier = multiplier;
  }

  public double getMultiplier(){
    return multiplier;
  }
}