package org.example;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class Snap extends CardGame {

    private static final int NUM_OF_PLAYERS = 2;
    private static final int SNAP_THRESHOLD_MS = 5_000;

    private Scanner scanner;
    private List<Player> players = new ArrayList<>();

    public Snap() {
        super("Snap!");
        scanner = new Scanner( System.in );
    }

    public void play() {

        System.out.println("Welcome to " + this.name);

        // create players
        for (int i = 0; i < NUM_OF_PLAYERS; i++) {
            Player player = createPlayer(i + 1);
            players.add(player);
        }

        // shuffle deck
        shuffleDeck();
//        sortDeckIntoNumberOrder();

        Card previousCard = null;
        int currentPlayerIndex = 0;
        Player currentPlayer = null;

        // until winner - infinite loop
        boolean playerWon = false;
        while( !playerWon ) {

            // select current player
            currentPlayer = this.players.get( currentPlayerIndex );

            // wait for user to press enter
            System.out.println("\nPress enter to draw next card " + currentPlayer.getName() + ":");
            String userInput = scanner.nextLine();

            // deal card
            Card currentCard = dealCard();
            if( currentCard == null ) {
                // reached end of deck!
                System.out.println("It's a draw!");
                break;
            }

            System.out.println("Card: " + currentCard);

            // compare new card with previous card (if available)

            if( previousCard != null ) {

                // if new card and previous card have same symbol then
                if( previousCard.getValue() == currentCard.getValue() ) {

                    if( readSnapInput() ) {
                        // player has won!
                        System.out.println("Congratulations!! " + currentPlayer.getName() + " has won!");
                        playerWon = true;
                        break;
                    } else {
                        System.out.println("You snooze you lose!");

                    }

                    // game over
                }

            }

            previousCard = currentCard;
            currentPlayerIndex = (currentPlayerIndex + 1) % this.players.size();

        } // end loop

        System.out.println("End of game");

    }

    /**
     * Waits for user to enter 'snap' within a certain time.
     * @return true if user entered snap within time limit
     */
    private boolean readSnapInput() {

        long startTime = Instant.now().toEpochMilli();
        String snap = scanner.nextLine();
        long elapsed = Instant.now().toEpochMilli() - startTime;
        if( snap.trim().equalsIgnoreCase("snap")  && elapsed < SNAP_THRESHOLD_MS ) {
            return true;
        }
        return false;
    }

    private Player createPlayer(int playerNumber) {
        System.out.println("Enter name for player " + playerNumber + ":");
        String playerName = scanner.nextLine();
        Player player = new Player( playerName.trim() );
        return player;
    }

    public static void main(String[] args) {

        Snap snap = new Snap();
        snap.play();

    }


}
