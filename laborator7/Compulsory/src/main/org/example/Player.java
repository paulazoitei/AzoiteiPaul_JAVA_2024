package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a player

 */
public class Player implements Runnable {
    private final String name;
    private Game game;
    private final List<Tile> tiles = new ArrayList<>();

    /**
     * Constructor that initializes the player with a name
     * @param name
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Method that set a game
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     *
     */
    /**
     * Runs the game loop in a thread, drawing tiles from the bag until interruption, game end, or
     * the bag is empty.
     */

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && !game.hasGameEnded()) {
            if (game.getBag().tiles.isEmpty()) {
                game.endGame();
                break;
            }
            List<Tile> extractedTiles = game.getBag().extractTiles(1);
            if (extractedTiles.isEmpty()) {
                break;
            }
            tiles.addAll(extractedTiles);
            System.out.println(name + " extracted: " + extractedTiles);


        }
    }
}