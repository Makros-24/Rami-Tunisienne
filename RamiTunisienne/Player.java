package RamiTunisienne;

public interface Player {
    public Action promptAction(Action[] actions, State state);

    public Card promptCard(State state);
    
    public int promptPos(State state);
}