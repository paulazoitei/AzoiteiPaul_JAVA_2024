

package org.example;

/**
 * Class that represents a time keeper

 */
public class TimeKeeper implements Runnable {
    private final Game game;
    private final long timeLimitMillis;

    /**
     * Constructor that initializes the time keeper with a game and a time limit in milliseconds
     * @param game
     * @param timeLimitMillis
     */
    public TimeKeeper(Game game, long timeLimitMillis) {
        this.game = game;
        this.timeLimitMillis = timeLimitMillis;
    }
    /**
     * Executes the game loop, continuously checking the elapsed time against a predefined time limit.
     * The loop runs as long as the game has not ended. If the elapsed time exceeds the time limit,
     * the game is terminated and a message is displayed. The loop also prints the elapsed time periodically.
     * If the thread is interrupted, the method returns immediately.
     */
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        while (!game.hasGameEnded()) {
            long currentTime = System.currentTimeMillis();
            long elapsedMillis = currentTime - startTime;

            if (elapsedMillis >= timeLimitMillis) {
                System.out.println("Time limit of " + timeLimitMillis + " milliseconds exceeded. Ending game.");
                game.endGame();
                return;
            }

            System.out.println("Milliseconds passed: " + elapsedMillis);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

                return;
            }
        }
    }

}
