package backjack.Model;

import backjack.utils.Cards.Card;
import backjack.utils.Cards.Rank;
import backjack.utils.Cards.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
  private final List<Card> deck = new ArrayList<>();

  public Deck(){
    for (Suit suit : Suit.values()){
      for (Rank rank : Rank.values()){
        deck.add(new Card(suit, rank));
      }
    }
  }

  public void shuffle(){
    Collections.shuffle(deck);
  }

  public Card draw(){
    if (deck.isEmpty()) return null;
    return deck.remove(deck.size() - 1);
  }
}
