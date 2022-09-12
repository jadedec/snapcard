package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CardGame {

    // constants
    private static final Suit[] SUITS = { Suit.spades, Suit.hearts, Suit.clubs, Suit.diamonds };
    private static final String[] SYMBOLS = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    protected List<Card> deckOfCards;
    protected String name;

    public CardGame(String name) {
        this.name = name;
        generateCards();
        shuffleDeck();
    }

    /**
     * Generates 52 cards for a deck of cards.
     */
    private void generateCards() {
        List<Card> cards = new ArrayList<>();

        for( Suit suit: SUITS ) {
            for (int i = 0; i < SYMBOLS.length; i++) {
                cards.add( new Card(suit, SYMBOLS[i], i+ 2));
            }
        }

        System.out.println(cards.size());
        this.deckOfCards = cards;
    }

    public String getName() {
        return name;
    }

    public void getDeck() {
        this.deckOfCards.forEach( card -> System.out.println(card) );
    }

    /**
     * Gets the top card of the deck.
     * @return top card or null if deck empty.
     */
    protected Card dealCard() {
        if( this.deckOfCards.isEmpty() ) {
            return null;
        }
        Card topCard = this.deckOfCards.remove(0);
        return topCard;
    }

    protected List<Card> shuffleDeck() {
        Collections.shuffle( this.deckOfCards );
        return this.deckOfCards;
    }

    protected List<Card> sortDeckIntoNumberOrder() {
        Collections.sort( this.deckOfCards, (a,b) -> {
            if( a.getValue() == b.getValue() ) {
                return a.getSuit().compareTo( b.getSuit() );
            }
            return a.getValue() - b.getValue();
        } );
        return this.deckOfCards;
    }

    protected List<Card> sortDeckIntoSuitOrder() {
        Collections.sort( this.deckOfCards, (a,b) -> {
            if( a.getSuit().equals( b.getSuit() ) ) {
                return a.getValue() - b.getValue();
            }
            return a.getSuit().compareTo( b.getSuit() );
        });
        return this.deckOfCards;
    }

    public static void main(String[] args) {
//        CardGame cardGame = new CardGame("No game");
//
//        System.out.println(cardGame.getName());
//        System.out.println(cardGame.dealCard());
//        System.out.println(cardGame.dealCard());
//        System.out.println(cardGame.dealCard());
//        System.out.println(cardGame.dealCard());
//        System.out.println( cardGame.deckOfCards.size() );
//        cardGame.sortDeckIntoSuitOrder();
//        cardGame.getDeck();


    }

}
