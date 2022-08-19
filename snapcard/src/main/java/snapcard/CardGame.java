package snapcard;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Contains an ArrayList<Card> for the deckOfCards that contains all 52 cards.
 * This is created and populated when the game is constructed.
 * Has a name which is also defined in the constructor.
 * Has a getDeck method that lists out the cards in the deck.
 */
public class CardGame {

    private ArrayList<Card> deckOfCards;
    private Map<String, List<Card>> cardMap = new HashMap<>();

    public CardGame() {
        deckOfCards = new ArrayList<Card>(52);
    }

    public void setDeckOfCards() {
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
                addCardsToMap(card);
            }
        }
    }

    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    private void addCardsToMap(Card card) {
        List<Card> cardList = cardMap.getOrDefault(card.getSuit(), new ArrayList<>());
        cardList.add(card);
        cardMap.put(card.getSuit(), cardList);
    }

    /**
     * Card dealCard()
     * Takes the card from the top of the deck and returns it.
     * <p>
     * ArrayList<Card> sortDeckInNumberOrder()
     * Sorts the deck in number order (e.g. 2222333344445555 etc) and stores the new shuffled deck back into the deckOfCards attribute.
     * <p>
     * ArrayList<Card> sortDeckIntoSuits()
     * Sorts the deck into suits (2,3,4,5,6,7,8,9,10,J,Q,K,A of hearts, then 2,3,4,5,6,7,8,9,10,J,Q,K,A of clubs etc.) and stores the new shuffleddeck back into the deckOfCards attribute.
     * <p>
     * ArrayList<Card> shuffleDeck()
     * Shuffles the deck into a random order and stores the new shuffled deck back into the deckOfCards attribute.
     */

    public Card dealCard() {
        return this.deckOfCards.get(0);
    }

    public ArrayList<Card> sortDeckInNumberOrder() {
        Collections.sort(deckOfCards, (a, b) -> a.getValue() - b.getValue());
        return deckOfCards;
    }

    public List<Card> sortDeckIntoSuits(String suit) {
        return this.cardMap.get(suit);
    }

    public ArrayList<Card> shuffleDeck() {
        int size = deckOfCards.size();
        ArrayList<Card> shuffleDeck = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int randomIndex = random.nextInt(size);
            Card swap = deckOfCards.get(randomIndex);
            shuffleDeck.add(swap);
        }
        return shuffleDeck;
    }


}

