package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Bag {
    public int n;
    public final List<Tile> tiles = Collections.synchronizedList(new ArrayList<>());


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



    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany && !tiles.isEmpty(); i++) {
            extracted.add(tiles.remove(0));
        }
        return extracted;
    }
}




