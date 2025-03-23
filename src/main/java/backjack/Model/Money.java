package backjack.Model;

import java.util.Objects;

public class Money {
  public static final String NEGATIVE_NUMBER = "음수를 사용할 수 없습니다.";
  private int money;

  public Money(int money){
    isValidMoney(money);
    this.money = money;
  }

  private void isValidMoney(int money) {
    if (money < 0) throw new IllegalArgumentException(NEGATIVE_NUMBER);
  }

  public int getMoney(){
    return money;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Money money1 = (Money) o;
    return money == money1.money;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(money);
  }
}
