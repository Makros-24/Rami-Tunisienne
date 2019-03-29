package RamiTunisienne;

import java.util.ArrayList;

public class State {
    private ArrayList<Card> hand;
    private int deckSize;
    private ArrayList<Card> discard;

    public State(ArrayList<Card> hand, int deckSize, ArrayList<Card> discard) {
        this.hand = hand;
        this.deckSize = deckSize;
        this.discard = discard;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getDeckSize() {
        return deckSize;
    }

    public ArrayList<Card> getDiscard() {
        return discard;
    }
}