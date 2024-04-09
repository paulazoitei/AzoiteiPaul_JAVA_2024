package org.example;

/**
 * Class that represents a tile

 */
public class Tile {
    private final int number1;
    private final int number2;
/**
 * Constructor that initializes the tile with two numbers
 */
    public Tile(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    /**
     * Method that returns the first number of the tile
     * @return
     */
    public int getNumber1() {
        return number1;
    }

    /**
     * Method that returns the second number of the tile
     * @return
     */
    public int getNumber2() {
        return number2;
    }

    /**
     * Method that returns the two numbers of the tile
     * @return
     */
    @Override
    public String toString() {
        return "(" + number1 + "," + number2 + ")";
    }
}