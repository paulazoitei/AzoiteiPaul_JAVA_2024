package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that represents the bag of tiles

 */
public class Bag {
    public final List<Tile> tiles = Collections.synchronizedList(new ArrayList<>());

    /**
     * Constructor that initializes the bag with n tiles
     * @param n
     */
    public Bag(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    tiles.add(new org.example.Tile(i, j));
                }
            }
        }
        Collections.shuffle(tiles);
    }

    /**
     * Method that extracts howMany tiles from the bag
     * @param howMany
     * @return
     */
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany && !tiles.isEmpty(); i++) {
            extracted.add(tiles.remove(0));
        }
        return extracted;
    }
}