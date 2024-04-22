
package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Class that represents a game
 */

public class Game {
    private final Bag bag;
    private int turnsTaken = 0;
    private boolean winnerAnnounced = false;
    private final List<Player> players = new ArrayList<>();
    private final AtomicBoolean gameEnded = new AtomicBoolean(false);

    private final Object turnLock = new Object();
    private volatile int currentPlayerIndex = 0;
    public  int winningSequenceLength;

    /**
     * Method that checks if a player has won
     * @return
     */
    public boolean hasPlayerWon() {
        return players.stream().anyMatch(player -> player.getScore() == winningSequenceLength);
    }

   /**
     * Constructor that initializes the game with a bag and a winning sequence length
    * @param n
    * @param winningSequenceLength
     */
    public Game(int n, int winningSequenceLength) {
        this.bag = new Bag(n);
        this.winningSequenceLength = winningSequenceLength;
    }

    /**
     * Method that returns the bag of the game
     * @return
     */

    public Bag getBag() {
        return bag;
    }

    /**
     * Method that returns the players of the game
     * @return
     */

    public boolean hasGameEnded() {
        return gameEnded.get();
    }

    /**
     * Method that ends the game
     */
    public void endGame() {
        gameEnded.set(true);
        synchronized (turnLock) {
            turnLock.notifyAll();
        }
        for (Player player : players) {
            player.getThread().interrupt();
        }
        if (!winnerAnnounced) {
            announceWinner();
        }
    }

    /**
     * Method that adds a player to the game
     * @param player
     */
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
        player.setIndex(players.size() - 1);
    }

    /**
     * Starts the game with each player running on a separate thread.
     * A TimeKeeper thread is also initiated to monitor the elapsed time.
     * If the time exceeds the specified time limit, the game is ended.
     * This method also contains the main game loop which repeatedly
     * checks for a winner until the game ends.

     */


    public void play() {


        for (int i = 0; i < players.size(); i++) {
            final int playerIndex = i;
            new Thread(() -> players.get(playerIndex).run()).start();
        }
        long timeLimitMillis = 30;
        TimeKeeper timeKeeper = new TimeKeeper(this, timeLimitMillis);
        Thread timeKeeperThread = new Thread(timeKeeper);
        timeKeeperThread.setDaemon(true);
        timeKeeperThread.start();


        while (!gameEnded.get()) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

                endGame();
            }


            checkForWinner();
        }

    }

    /**
     * Method that moves the turn to the next player
     */

    public void nextPlayerTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();

        turnsTaken++;
        turnLock.notifyAll();
    }

    /**
     * Method that returns the turn lock
     * @return
     */
    public Object getTurnLock() {
        return turnLock;
    }

    /**
     * Method that returns the current player index
     * @return
     */
    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }


    /**
     * Determines and announces the winner of the game.
     * This method is synchronized to ensure that the announcement is
     * made only once and thread-safely. The winner is the player
     * with a valid closed sequence of the greatest length. If no such
     * sequences exist, a message is displayed stating that there is no winner.
     */


    private synchronized void announceWinner() {
        if (winnerAnnounced) {
            return;
        }
        winnerAnnounced = true;

        Optional<Player> winner = players.stream()
                .filter(Player::hasValidClosedSequence)
                .max(Comparator.comparingInt(Player::getScore));

        if (winner.isPresent()) {
            System.out.println(winner.get().getName() + " wins with a sequence of length " + winner.get().getScore());
        } else {
            System.out.println("No winner as no player formed a valid sequence.");
        }
    }

    /**
     * Checks if any player has won the game by achieving the winning sequence length or
     * if all tiles have been extracted from the bag without any player winning.
     * The game ends when a player wins or when there are no more tiles to draw.
     */
    public void checkForWinner() {
    Optional<Player> possibleWinner = players.stream()
            .filter(player -> player.getScore() == winningSequenceLength)
            .findFirst();

    if (possibleWinner.isPresent()) {
        endGame();
    } else if (bag.tiles.isEmpty()) {
        endGame();
    }
}


    public static void main(String[] args) {
        int winningSequenceLength = 3;
        Game game = new Game(5, winningSequenceLength);
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }

}







