package RamiTunisienne;

public enum Suit {
    CLUB ("clubs", 'C', "C"),
    DIAMOND ("diamonds", 'D', "D"),
    HEART ("hearts", 'H', "H"),
    SPADE ("spades", 'S', "S");

    private final String name;
    private final char letter;
    private final String symbol;

    Suit(String name, char letter, String symbol) {
        this.name = name;
        this.letter = letter;
        this.symbol = symbol;
    }

    public String toString() {
        return symbol;
    }

    public static Suit fromString(char s) throws Exception {
        for (Suit suit : Suit.values()) {
            if (s == suit.letter) {
                return suit;
            }
        }
        throw new Exception("Cannot convert: " + s + " from String to Suit");
    }
}