package org.example;

public enum Suit {

    spades( '\u2660' )
    ,hearts( '\u2665')
    ,clubs( '\u2663' )
    ,diamonds( '\u2666')
    ;

    private char icon;

    Suit(char icon) {
        this.icon = icon;
    }

    public char getIcon() {
        return icon;
    }

}
