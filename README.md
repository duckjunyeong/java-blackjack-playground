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

각 플레이어들 마다 수익과 손해를 관리하는 변수들도 만들까? 
그리고 플레이들 중에 21의 점수가 넘은 애들은 어떻게 하지? 
버스트? 처리를 해줘야하나 그 즉시 해당플레이어를 참여하지 못 하게 
버스트라는 것을 관리하는 변수를 하나 만든다면 카드를 계속 뽑게 막을 수도 있고 버스트인 즉시 딜러에게 돈을 주고 자신은 해당 round에서 나가게 할 수 있음 
그니깐 버스트가 되면 딜러에게 돈을 주고 자신의 수익을 - 한다음 다음 턴으로 넘기게 됨 

< 블랙잭 구현 과정 >
1. 플레이어를 입력받는다. (, 기준으로)
2. 각 플레이어마다 배팅금액을 입력받는다.
3. 딜러와 플레이어들에게 2장씩 랜덤 카드를 배분한다.
4. 각 플레이어들이 카드를 더 뽑을지 결정한다.
    - 이 때 플레이어의 점수가 21을 초과한다면 배당금액을 0으로 만든다.
5. 딜러의 숫자가 16이하인지 판단하고 16이하라면 한 장 더 뽑는다.
6. 딜러와 플레이어들의 점수를 공개한다.
   - 딜러의 점수를 확인하고 21을 초과했다면 모든 플레이어들에게 각자의 배당금액만큼 돈을 준다.
        - 플레이어들을 순회하면서 각자 배당금액을 int lostCost에 더해주면서 딜러의 손해액을 계산함과 동시에 플레이어들의 수익을 Map에다 넣어준다. 게임종료 
        - 플레이어와 딜러의 승패를 가려 각 플레이어 수익 또는 손해액을 계산해준다.
            - 둘 다 블랙잭인 경우 (처음 2장의 카드가 21점인 경우) == 무승부 
            - 플레이어가 승리한 경우
                - 블랙잭으로 승리한 경우 (배당액의 1.5배의 수익)
                - 스코어로 승리한 경우 (배당액이 1.0배의 수익)
            - 딜러가 승리한 경우 
                - 블랙잭 or 스코어로 승리한 경우 (플레이어의 배당액의 1.0배의 수익)

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
    - List<Participant> 를 넘겨주면 가장 먼저 dealer의 점수가 21이 넘는지 확인한다. 
            - 일단 순회하면서 dealer뽑고 CardScoreCalcualtor를 통해 dealer의 점수를 계산한다. 점수가 21이라면 플레이어들의 리스트를 순회하면서
               반환할 Map 데이터를 생성하면 된다. 자신의 배당한 금액만큼 돌려받음
   
    - 플레이어와 딜러의 승패를 가려 각 플레이어 수익 또는 손해액을 계산해준다.
      - 둘 다 블랙잭인 경우 (처음 2장의 카드가 21점인 경우) == 무승부
      - 플레이어가 승리한 경우
      - 블랙잭으로 승리한 경우 (배당액의 1.5배의 수익)
      - 스코어로 승리한 경우 (배당액이 1.0배의 수익)
      - 딜러가 승리한 경우
      - 블랙잭 or 스코어로 승리한 경우 (플레이어의 배당액의 1.0배의 수익)


플레이어가 버스트 걸린경우
- 바로 돈 가져가고 딜러에게 돈 주면 됨

딜러가 버스트 걸린경우
- 모든 플레이어에게 돈을 나눠주는데 블랙잭이면 1.5배줘야함. 



< Class 설계 >

< controller >

List<Player> playerList = inputview.readPlayers(); // 이름만 입력받음 



딜러의 결과가 16이하라면 하나 더 뽑는다.
결과 발표 


< model >

class Dealer
    - 변수
        - `private List<Card> cardList`
        - `private int revenue`



Class Player
    - 변수
        - `private Name name;`
        - `private Money diveDends`
        - `private List<Card> cardList`
        - `private int revenue`
        


< utils >
Class Referee
    - 메서드
        - void determineVictory(Dealer dealer, Player player)   


class PayoutCalcualtor
    - 메서드
        - void determinePayout(Dealer dealer, Player player, BlackJackResult blackjackResult)

view
Class InputView
    - 메서드
        - List<Player> readplayers() : player들을 입력받고 배팅할 금액까지 입력받는다.