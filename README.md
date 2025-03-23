- Optional 잘 사용하기
1. isPresent()함수 사용하지 말고 ifPresent() 함수, orElse, orElseThorw 함수 사용하기
2. orElse는 상수나 변수를 반환할 때 사용할 것
3. orElseGet는 매개변수로 함수를 넣을 떄 사용할 것 
4. Optional은 반환을 할 때만 사용을 할 것, 멤버 변수나, 함수의 매개변수로 사용하지 말 것--> 불필요한 객체생성 및 직렬화가 없음 
5. flatMap( Optional을 반환) 와 같은 API를 잘 활용하면 가독성을 개선할 수 있음 

- 제네릭 이해하기
1. 제네릭클래스와 제네릭메서드의 구분
class Pieces<T extends Piece> { 


  public <T extends Car> T createCar(T car1, T car2) // 해당 T와 클래스를 생성할 때 사용되는 T는 서로 독립적인 T이다. 즉 <> 연산자는 하나의 
                                                        해당 스코프에서 사용할 타입??을 지정해준다라고 생각하면 될 것 같다. 


}

2. 제네릭은 형변환을 할 수 없다. --> '?' 와일드카드를 사용하면 형변환이 가능하다. 이 와일드카드는 설계할 때 사용하는 것이 아닌 사용할 때 사용되어야한다.




21 또는 21에 가까우면 이김 
king queen Jack --> 10
Ace --> 1 or 11
21에 가깝게 만든다면 계속 카드를 뽑을 수 있음 
21을 초과하면 배팅액을 모두 잃음 
딜러는 처음에 2장을 받고 16이하라면 1장 더 아니면 끝 --> 21초과하면 플레이어 승리 
처음부터 21이라면 1.5배의 배팅액 

< 블랙잭 구현 과정 >
1. 플레이어를 입력받는다. (, 기준으로)
2. 각 플레이어마다 배팅금액을 입력받는다.
3. 딜러와 플레이어들에게 2장씩 랜덤 카드를 배분한다.
4. 각 플레이어들이 카드를 더 뽑을지 결정한다.
   4-1. 이 때 21을 초과하면 게임이 종료된다. 배팅금액을 나머지사람들에게 나눠준다.
5. 딜러의 숫자가 16이하인지 판단하고 16이하라면 한 장 더 뽑는다.
    5-1. 이 때 21을 초과하면 게임이 종료된다. 배팅한 금액만큼 플레이어들은 수익을 얻는다.

6. 딜러와 플레이어들의 점수를 공개한다.
    - 딜러 및 플레이어들에게 지급될 돈을 관리하는 Map자료구조를 사용 "jun" -> 1000 "dealer" -> 2000 .....
    - 딜러의 점수가 21을 초과했는지 확인한다. 초과했다면 플레이어들의 배당금액만큼 받는다. ==> 즉 자기자신의 배당액도 알고 있어야한다는거네
    - 모두 블랙잭이면 각자 모두 수익 0

    - 이긴 사람을 제외한 나머지 사람들의 배당금액을 이긴사람에게 균등하게 분배한다.
        - 딜러 및 플레이들을 순회하면서 각자의 점수를 21로 뺀다.
        - 가장 작은 값을 가진 player들을 따로 추출한다.
        - 배당액을 이긴사람들의 수만큼 나눠서 분배를 한다
        - 해당 플레이어가 블랙잭이라면 1.5배 더 준다. 

< TDD 과정 >

1. 클로버, 다이아, 하트, 스페이드중에서 그리고 Ace~King 중에서 랜덤한 카드를 생성해는지 테스트한다.
2. 특정 카드를 보고 점수가 몇인지 올바르게 반환하는데 테스트한다.
3. 카드의 리스트를 주었을 때 점수를 합산하는지 테스트한다.
4. "에이스" 를 제외한 모든 숫자를 더하고 마지막에 ACE가 존재한다면 21에 가깝게 합산을 하는지 테스트한다.
5. 플레이어를 입력받고 ,를 기준으로 split한다.
    - 입력받은 문자열의 모든 공백을 지운다.
    - split으로 나눈다.
    - 나눠진 배열을 순회하면서 Player객체를 생성한다.
    - 여기서 다시 순회하면서 Player들의 배팅액을 입력받는다. 
   
6. players들을 순회하면서 2장씩 카드를 나눠준다.
     - Player들 반복문돌리고 하나하나의 플레이어들의 카드리스트에 넣어준다. 반복문을 돌리고 난 후 딜러에게 카드를 준다

7. 승자의 점수를 뽑고 그 승자의 점수에 해당하는 participant들을 출력해본다. 





< Class 설계 >

< controller >

List<Player> playerList = inputview.readPlayers(); // 이름만 입력받음 



딜러의 결과가 16이하라면 하나 더 뽑는다.
결과 발표 


< model >

class Dealer
    - 변수
        - `private List<Card> cardList`


Class Player
    - 변수
        - `private Name name;`
        - `private Money diveDends`
        - `private List<Card> cardList`
        


utils
interface Card
abstract class AbstractCard 

class Diamonds impelments AbstractCard
class Clubs impelments AbstractCard
class Hearts impelments AbstractCard
class Spades impelments AbstractCard

class CardNumTranslator : 숫자가 주어지면 해당 숫자에 해당하는 CardNumber이름을 반환한다 ex) 1 -> "A"
class RandomCardGenerator : 랜덤한 카드를 생성하는 클래스 
class CardScoreCalcualtor : card 점수 계산 



view
Class InputView
    - 메서드
        - List<Player> readplayers() : player들을 입력받고 배팅할 금액까지 입력받는다.