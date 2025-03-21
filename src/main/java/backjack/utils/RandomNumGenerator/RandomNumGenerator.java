package backjack.utils.RandomNumGenerator;

import java.util.Random;

public class RandomNumGenerator {
  private final static Random random = new Random();

  public static int getRandomNumber(int start, int end){
    return random.nextInt(end - start) + start + 1;
  }
}
