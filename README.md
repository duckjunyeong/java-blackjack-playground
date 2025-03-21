- Optional 잘 사용하기
1. isPresent()함수 사용하지 말고 ifPresent() 함수, orElse, orElseThorw 함수 사용하기
2. orElse는 상수나 변수를 반환할 때 사용할 것
3. orElseGet는 매개변수로 함수를 넣을 떄 사용할 것 
4. Optional은 반환을 할 때만 사용을 할 것, 멤버 변수나, 함수의 매개변수로 사용하지 말 것--> 불필요한 객체생성 및 직렬화가 없음 
5. flatMap( Optional을 반환) 와 같은 API를 잘 활용하면 가독성을 개선할 수 있음 



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
6. 딜러와 플레이어들의 결과들을 출력한다.
7. 최종 수익을 발표한다. 




< Class 설계 >

controller
List<Player> playerList = inputview.readPlayers();
딜러와 playerList들에게 카드를 랜덤으로 부여한다.
playerList를 순회하며 더 뽑을지 결정한다.
딜러의 결과가 16이하라면 하나 더 뽑는다.
결과 발표 


< TDD 과정 >

1. 클로버, 다이아, 하트, 스페이드중에서 그리고 Ace~King 중에서 랜덤한 카드를 생성해는지 테스트한다.
2. 특정 카드를 보고 점수가 몇인지 올바르게 반환하는데 테스트한다.
3. 카드의 리스트를 주었을 때 점수를 합산하는지 테스트한다.
4. "에이스" 를 제외한 모든 숫자를 더하고 마지막에 ACE가 존재한다면 21에 가깝게 합산을 하는지 테스트한다.


model

class Dealer
    - 변수
        - `내가 부여받은 카드이름`


Class Player
    - 변수
        - `private int 배팅한금액`
        - `내가 부여받은 카드이름`
        


utils
interface Card
abstract class AbstractCard 

class Diamonds impelments Card
class Clubs impelments Card
class Hearts impelments Card
class Spades impelments Card

class CardNumTranslator : 숫자가 주어지면 해당 숫자에 해당하는 CardNumber이름을 반환한다 ex) 1 -> "A"
class RandomCardGenerator : 랜덤한 카드를 생성하는 클래스 
class CardScoreCalcualtor : card 점수 계산 



view
Class InputView
    - 메서드
        - List<Player> readplayers() : player들을 입력받고 배팅할 금액까지 입력받는다.