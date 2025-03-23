package backjack.Model;

import java.util.Objects;

public class Name {

  public static final String EMPTY_STRING = "Player의 이름으로 빈 값이 들어왔습니다.";
  private String name;

  public Name(String name){
    isValidName(name);
    this.name = name;
  }

  private void isValidName(String name) {
    if (name.trim().equals("")) throw new IllegalArgumentException(EMPTY_STRING);
  }

  public String getName(){
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Name name1 = (Name) o;
    return Objects.equals(name, name1.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }
}
