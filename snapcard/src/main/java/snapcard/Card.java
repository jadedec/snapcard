package snapcard;

/**
 * Has a String suit. Use the unicode characters of heart, club, diamond and spade.
 * Has a String symbol (2,3,4,5,6,7,8,9,10,J,Q,K,A)
 * Has an int value (2,3,4,5,6,7,8,9,10,11,12,13,14)
 * Has a toString method that describes the class
 */

public class Card {

    private String suit;
    private String symbol;
    private int value;

    protected Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getSuit() + " " + getSymbol();
    }
}
