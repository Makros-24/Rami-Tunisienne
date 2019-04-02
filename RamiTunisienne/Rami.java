package RamiTunisienne;

import java.util.ArrayList;
import java.util.HashMap;


public class Rami {
	static int turn=1;
	static int man3a=71;
	public static Action[] getAvailableActions(State state) {
		if(state.getHandSize()>14)
			return new Action[] {Action.DISCARD};
		if(turn>=1&&turn<=4)
		{
			turn++;
			return new Action[] {Action.DRAW_STOCK,Action.SWITCH_CARDS};
		}
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