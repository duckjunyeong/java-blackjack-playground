package backjack.utils.RandomGenerator;

import java.util.Random;

public class RandomGenerator {
  private final static Random random = new Random();

  public static int getRandomNumber(int start, int end){
    return random.nextInt(end - start) + start + 1;
  }
}
