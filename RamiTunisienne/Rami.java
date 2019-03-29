package RamiTunisienne;

import java.util.ArrayList;
import java.util.HashMap;


public class Rami {
	static int intial=1;
    public static Action[] getAvailableActions(State state) {
    	if(state.getDiscard().isEmpty()&&(intial==1)){
    		intial++;
            return new Action[] {Action.DRAW_STOCK};}
         else if (state.getHand().size() == 14) 
             return new Action[] {Action.DRAW_STOCK, Action.DRAW_DISCARD};
         else if (isHandKnockable(state)) 
            return new Action[]{Action.KNOCK, Action.DISCARD};
         else 
            return new Action[] {Action.DISCARD};
    }

    public static boolean isHandKnockable(State state) {
        return calcDeadwood(state) <= 14;
    }


    private static HashMap<ArrayList<Card>, Integer> mem = new HashMap<>();

    public static int calcDeadwood(State state) {
        ArrayList<Card> hand = state.getHand();
        return 15;
    }
}