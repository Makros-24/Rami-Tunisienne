package RamiTunisienne;

import java.util.ArrayList;
import java.util.HashMap;


public class Rami {
	static int tour=1;
	static int man3a=71;
	static boolean turn=true;
	public static Action[] getAvailableActions(State state) {
			if(state.getHandSize()>14) {
				return new Action[] {Action.DISCARD,Action.SWITCH_CARDS};
			}
			else if(tour>=1&&tour<=5)
			{
				tour++;
				return new Action[] {Action.DRAW_STOCK,Action.SWITCH_CARDS};
			}
			else if (state.getHand().size() == 14) {
				return new Action[] {Action.DRAW_STOCK, Action.DRAW_DISCARD,Action.SWITCH_CARDS};
			}
			else if (isHandKnockable(state)) {
				return new Action[]{Action.KNOCK, Action.DISCARD,Action.SWITCH_CARDS};
			}
			else { 
				
				return new Action[] {Action.DISCARD,Action.SWITCH_CARDS};
			}
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