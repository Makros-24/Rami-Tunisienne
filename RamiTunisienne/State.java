package RamiTunisienne;

import java.util.ArrayList;

public class State {
    private ArrayList<Card> hand;
    private int deckSize;
    private ArrayList<Card> discard;
    private int Man3a;

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
    
    public int getHandSize() {
    	return hand.size();
    }
    
    public int getMan3a() {
    	//les condition de calcul ta3 el man3a
    	int s=0;
    	for(int i=0;i<=hand.size()-3;i++) {
        if ( hand.get(i).getOrder()==hand.get(i+1).getOrder() && hand.get(i+2).getOrder()==hand.get(i+1).getOrder()&&hand.get(i+3).getOrder()==hand.get(i+1).getOrder() ) {
        	s+=hand.get(i).getValue()+hand.get(i+1).getValue()+hand.get(i+2).getValue();
        }
        else if ( hand.get(i).getOrder()==hand.get(i+1).getOrder() && hand.get(i+2).getOrder()==hand.get(i+1).getOrder() ) {
    		s+=hand.get(i).getValue()+hand.get(i+1).getValue()+hand.get(i+2).getValue();
    	}
    	}
    		
    	return s;
    }
   
}