package snapcard;

import java.util.ArrayList;

/**
 * Create a Player class and enable the snap game to be two player, with the users taking it in turns to go. If the snap occurs on the usersturn, they win.
 * Add a timer so that when there is a snap opportunity, the player has 2 seconds to submit the word “snap” in order to win. If they don’ttype it in time, they lose.
 */
public class Player {

    private String name;

    public Player(String name) {

        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player: " + name;
    }
}
