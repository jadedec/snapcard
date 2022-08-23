package snapcard;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class Snap extends CardGame {

    public Snap() {
        super();
        this.shuffleDeck();
    }

    Scanner scanner = new Scanner(System.in);
    boolean gameOn = true;
    boolean haveWinner = false;
    boolean haveSnap = false;
    String snapInput = "";
    String previousCardSymbol = "";
    String currentCardSymbol = "";
    int turn = 1;

    public void game() {

        System.out.println("Please enter name of Player 1");
        Player one = new Player(scanner.nextLine());
        System.out.println("Please enter name of Player 2");
        Player two = new Player(scanner.nextLine());

        System.out.println("Press enter to take your turn.");



        while (gameOn) {
            Card previousCard = super.dealCard();
            Card currentCard = super.dealCard();
            System.out.println(currentCard);
            previousCardSymbol = previousCard.getSymbol();
            currentCardSymbol = currentCard.getSymbol();

            if (turn == 1) {
                System.out.println(one.getName() + " 's turn");
                one.setTurn();
            } else {
                System.out.println(two.getName() + " 's turn");
                two.setTurn();
            }

            snapInput = scanner.nextLine();
            this.timer();

            if (haveSnap && haveWinner) {
                if (turn == 1) {
                    System.out.println(one.getName() + " is the winner");
                    gameOn = false;
                    break;
                } else {
                    System.out.println(two.getName() + " is the winner");
                    gameOn = false;
                    break;
                }
            }

        }
    }


    TimerTask task = new TimerTask() {
        // run() method to carry out the action of the task
        public void run() {
            if (snapInput.equals("")) {
                System.out.println("-----------");
                System.out.println("you didn't input anything in 2 seconds");
                System.out.println("you missed");
                System.out.println("-----------");
            }
        }
    };

    public void timer() {
        Timer timer = new Timer();
        timer.schedule(task, 2000);
        snapInput = scanner.nextLine();
        // cancel method to cancel the execution
        timer.cancel();
        this.winnerCheck();
        this.snapCheck();
    }

    public void winnerCheck() {
        if (snapInput.toLowerCase().equals("snap")) {
            haveWinner = true;
        } else {
            haveWinner = false;
        }
    }

    public void snapCheck() {
        if (currentCardSymbol.equals(previousCardSymbol)) {
            haveSnap = true;
        } else {
            haveSnap = false;
        }
    }


}
