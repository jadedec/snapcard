package org.example;

public class Card {

    // immutable!
    private final Suit suit;
    private final String symbol;
    private final int value;

    public Card(Suit suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return symbol + " " + suit.getIcon();
    }

//    public static void main(String[] args) {
//        Card aceOfSpades = new Card( Suit.spades, "a", 14 );
//        System.out.println(aceOfSpades);
//    }

}
