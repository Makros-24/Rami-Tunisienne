package RamiTunisienne;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HumanPlayer implements Player {

    @Override
    public Action promptAction(Action[] actions, State state) {
        System.out.println("Hand: " + state.getHand());
        if (state.getDiscard().size() > 0) {
            System.out.println("Byou3 la3bed: " + state.getDiscard().get(0));
        } else {
            System.out.println("Byou3 la3bed: Fer8a");
        }

        Action a = null;
        while (a == null) {
            System.out.println("Please choose an action: " + Stream.of(actions).map(Action::toString).collect(Collectors.joining(", ")));
            Scanner reader = new Scanner(System.in);

            String s = reader.next();

            switch (s) {
                case "S":
                    a = Action.DRAW_STOCK;
                    break;
                case "T":
                    a = Action.DRAW_DISCARD;
                    break;
                case "K":
                    a = Action.KNOCK;
                    break;
                case "D":
                    a = Action.DISCARD;
                    break;
            }
        }

        return a;
    }

    @Override
    public Card promptCard(State state) {
        Card card = null;
        while (card == null) {
            System.out.println("Bi3 carta: " + state.getHand());
            Scanner reader = new Scanner(System.in);

            String s = reader.next();
            Card c = null;
            try {
                c = Card.fromString(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (state.getHand().contains(c)) {
                card = c;
            }
        }

        return card;
    }
}