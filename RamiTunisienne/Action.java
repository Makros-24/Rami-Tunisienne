package RamiTunisienne;

public enum Action {
    DRAW_STOCK ("Techri carta mel Deck", "S"),
    DRAW_DISCARD ("Techri mel tawla", "T"),
  //  Man3a("Tamna3","M"),
    SWITCH_CARDS("Switch Cards", "W"),
    KNOCK ("tefrech", "K"),
    DISCARD ("Byou3", "D");

    private final String fullName;
    private final String symbol;

    public String toString() {
        return fullName + " (" + symbol + ")";
    }

    Action(String fullName, String symbol) {
        this.fullName = fullName;
        this.symbol = symbol;
    }
}