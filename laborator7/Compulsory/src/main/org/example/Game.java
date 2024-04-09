package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Class that represents the game

 */
public class Game {
    private final Bag bag;
    private final List<Player> players = new ArrayList<>();
    private final AtomicBoolean gameEnded = new AtomicBoolean(false);

    /**
     * Constructor that initializes the game with n tiles
     * @param n
     */
    public Game(int n) {
        this.bag = new Bag(n);
    }

    /**
     * Method that returns the bag of the game
     * @return
     */
    public Bag getBag() {
        return bag;
    }

    /**
     * Method that returns if the game has ended
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
    }

    /**
     * Method that adds a player to the game
     * @param player
     */
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    /**
     * Method that starts the game
     */
    public void play() {
        for (Player player : players) {
            new Thread(player).start();
        }
    }





public static void main(String[] args) {
        Game game = new Game(5); // Example with n=5
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }

}