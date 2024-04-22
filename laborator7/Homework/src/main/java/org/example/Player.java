


package org.example;

import java.util.*;

/**
 * Class that represents a player

 */
public class Player implements Runnable {
    private final String name;
    private Thread currentThread;
    private Game game;
    private final List<Tile> tiles = new ArrayList<>();
    private final List<List<Tile>> openSequences = new ArrayList<>();
    private int score = 0;
    private int index;

    /**
     * Constructor that initializes the player with a name
     * @param name
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Method that sets the game of the player
     * @param game
     */

    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Method that returns the thread of the player
     * @return
     */
    public Thread getThread() {
        return currentThread;
    }

    /**
     * Executes the player's turn in the game. The method will loop until the game ends or the thread is interrupted.
     * During their turn, players will wait for their turn lock, draw a tile, attempt to create a sequence,
     * and then notify the next player to take their turn.
     */
@Override
public void run() {
    currentThread = Thread.currentThread();
    while (!game.hasGameEnded() && !currentThread.isInterrupted()) {
        synchronized (game.getTurnLock()) {
            while (!game.hasGameEnded() && game.getCurrentPlayerIndex() != this.index) {
                try {
                    game.getTurnLock().wait();
                } catch (InterruptedException e) {

                    return;
                }
            }



            if (game.hasGameEnded() || currentThread.isInterrupted()) {
                break;
            }



            if (!game.getBag().tiles.isEmpty()) {
                Tile extracted = game.getBag().extractTiles(1).get(0);
                tiles.add(extracted);
                System.out.println(name + " extracted: " + extracted);
                tryCreateSequence(extracted);
            } else {

                game.endGame();
                break;
            }


            game.nextPlayerTurn();
        }


        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {

            return;
        }
    }
}


    /**
     * Attempts to create a sequence with a newly drawn tile. If the tile can continue an existing sequence, it is added.
     * Otherwise, a new sequence is started with the tile. If a sequence is closed and unique, the player's score is updated.
     *
     * @param newTile The tile that has been drawn and is to be added to a sequence.
     */

private void tryCreateSequence(Tile newTile) {
    boolean addedToExistingSequence = false;

    for (List<Tile> sequence : openSequences) {
        if (canAddToSequence(sequence, newTile)) {
            sequence.add(newTile);
            addedToExistingSequence = true;
            if (isSequenceClosedAndUnique(sequence)) {
                updateScore(sequence.size());
            }
        }
    }

    if (!addedToExistingSequence) {
        List<Tile> newSequence = new ArrayList<>();
        newSequence.add(newTile);
        openSequences.add(newSequence);
    }
}
    private boolean wouldCloseSequence(List<Tile> sequence, Tile newTile) {
        if (sequence.isEmpty()) {
            return false;
        }
        Tile lastTile = sequence.get(sequence.size() - 1);
        Tile firstTile = sequence.get(0);
        return lastTile.getNumber2() == newTile.getNumber1() && newTile.getNumber2() == firstTile.getNumber1();
    }

    /**
     * Determines if a new tile can be added to a given sequence. A tile can be added if it continues the sequence without closing it,
     * or if adding it would properly close the sequence at the winning length.
     *
     * @param sequence The current open sequence to which the tile may be added.
     * @param newTile   The tile to be added to the sequence.
     * @return true if the tile can be added to the sequence, false otherwise.
     */
    private boolean canAddToSequence(List<Tile> sequence, Tile newTile) {
        if (sequence.isEmpty()) {
            return true;
        }

        Tile lastTileInSequence = sequence.get(sequence.size() - 1);


        if (lastTileInSequence.getNumber2() == newTile.getNumber1()) {
            if (sequence.size() + 1 < game.winningSequenceLength) {
                return true;
            } else {

                Tile firstTileInSequence = sequence.get(0);
                return newTile.getNumber2() == firstTileInSequence.getNumber1();
            }
        }

        return false;
    }

    /**
     * Method that checks if the player has a valid closed sequence
     * @return
     */
    public boolean hasValidClosedSequence() {
        return openSequences.stream().anyMatch(this::isSequenceClosedAndUnique);
    }

    /**
     * Verifies if a sequence of tiles is closed and contains unique numbers.
     * A sequence is considered closed if the first number of the first tile equals the second number of the last tile.
     * Each number within the sequence (excluding the second number of the last tile and the first number of the first tile)
     * must be unique.
     *
     * @param sequence The list of Tile objects representing the sequence to be evaluated.
     * @return true if the sequence is closed and all numbers (except for the mentioned exceptions) are unique; false otherwise.
     */
    private boolean isSequenceClosedAndUnique(List<Tile> sequence) {
        if (sequence.size() < 2 || sequence.get(0).getNumber1() != sequence.get(sequence.size() - 1).getNumber2()) {
            return false;
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < sequence.size(); ++i) {
            Tile tile = sequence.get(i);
            if (i == 0 || i == sequence.size() - 1) {
                uniqueNumbers.add(tile.getNumber1());
            } else {
                if (!uniqueNumbers.add(tile.getNumber1()) || !uniqueNumbers.add(tile.getNumber2())) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Method that updates the score of the player
     * @param newScore
     */
    private void updateScore(int newScore) {
        if (newScore > score) {
            score = newScore;
        }
    }

    /**
     * Method that returns the score of the player
     * @return
     */
    public int getScore() {
        return score;
    }
    /**
     * Method that returns the name of the player
     * @return
     */

    public String getName() {
        return name;
    }

    /**
     * Method that returns the tiles of the player
     * @param i
     */
    public void setIndex(int i) {
        this.index = i;
    }
}


