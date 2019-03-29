package RamiTunisienne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }

    }

    public String toString() {
        return cards.stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }
}
