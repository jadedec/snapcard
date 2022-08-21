package snapcard;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class CardGame {

    private ArrayList<Card> deckOfCards;

    public CardGame() {
        deckOfCards = new ArrayList<Card>(52);
        for (String suit : new String[]{"heart", "club", "diamond", "spade"}) {
            for (String symbol : new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"}) {
                int value;
                switch (symbol) {
                    case "J":
                        value = 11;
                        break;
                    case "Q":
                        value = 12;
                        break;
                    case "K":
                        value = 13;
                        break;
                    case "A":
                        value = 1;
                        break;
                    default:
                        value = Integer.parseInt(symbol);
                }
                Card card = new Card(suit, symbol, value);
                this.deckOfCards.add(card);
            }
        }
    }


    public void getDeckOfCards() {
        for (Card card:deckOfCards){
            System.out.println(card);
        }
    }


    public Card dealCard() {
        return this.deckOfCards.remove(0);
    }

    public ArrayList<Card> sortDeckInNumberOrder() {
        Collections.sort(deckOfCards, (a, b) -> a.getValue() - b.getValue());
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits(String suit) {
        Collections.sort(deckOfCards, (a, b) -> a.getSuit().compareTo(b.getSuit()));
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck() {

        /*int size = deckOfCards.size();
        ArrayList<Card> shuffleDeck = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int randomIndex = random.nextInt(size);
            Card swap = deckOfCards.get(randomIndex);
            shuffleDeck.add(swap);
        }
        return shuffleDeck;*/

        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }

}

