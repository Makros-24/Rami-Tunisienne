package RamiTunisienne;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private Deck deck;
    private ArrayList<Card> discard;
    private ArrayList<Card>[] hands;
    public static final int HAND_SIZE = 14;
    private boolean knocked;
    private Player[] players;
    private int turn;
    private static Rami rami;
    public static boolean test=true;

    public Game() {
        deck = new Deck();
   //     System.out.println("size initial"+deck.size());
        deck.shuffle();
        knocked = false;
        discard = new ArrayList<>();
        hands = new ArrayList[]{new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()};
        players = new Player[]{new HumanPlayer(), new HumanPlayer(), new HumanPlayer(), new HumanPlayer()};
        turn = 1;

        IntStream.range(0, HAND_SIZE).forEach(
                i -> {
                    for (ArrayList<Card> hand : hands) {
                        hand.add(deck.draw());
                    }
                }
        );
        //discard.add(0, deck.draw());
    }
    

    public void run() {
        while (!knocked && deck.size() > 2) {
            Player p = players[turn % players.length];
            ArrayList<Card> hand = hands[turn % players.length];
            test=true;

            // Draw
            while(test) {
            State state = new State(hand, deck.size(), discard);
            Action action = p.promptAction(rami.getAvailableActions(state), state);
            Card card;
            switch (action) {
                case DRAW_STOCK:
                    card = deck.draw();
                    hand.add(card);
                    test=false;
                    break;
                case DRAW_DISCARD:
                    card = discard.remove(0);
                    hand.add(card);
                    test=false;
                    break;
                case SWITCH_CARDS:
                    card = p.promptCard(state);
                    int pos=p.promptPos(state);
                	hand.remove(card);
                	hand.add(pos,card);
                	break;
            }
            test=true;
            // Discard or Knock
            state = new State(hand, deck.size(), discard);
            action = p.promptAction(rami.getAvailableActions(state), state);

            switch (action) {
                case DISCARD:
                    card = p.promptCard(state);
                    hand.remove(card);
                    discard.add(0, card);
                    test=false;
                    break;
                case SWITCH_CARDS:
                    card = p.promptCard(state);
                    int pos=p.promptPos(state);
                	hand.remove(card);
                	hand.add(pos,card);
                	break;
                case KNOCK:
                    knocked = true;
                    test=false;
                    break;
            }
            }

            turn++;
        }
    }

    public String toString() {
        String s = "";
        s += "Deck: " + deck + "\n";
        s += "5arjou: " + discard.stream().map(Object::toString).collect(Collectors.joining(", ")) + "\n";
        for (ArrayList<Card> hand : hands) {
            s += "Hand: " + hand.stream().map(Object::toString).collect(Collectors.joining(", ")) + "\n";
        }
        return s;
    }
}