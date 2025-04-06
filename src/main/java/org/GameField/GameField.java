package org.GameField;

import org.Organism.Animals.Predator.Wolf;

public class GameField {
    private int width;
    private int height;
    private Cell[][] cells;

    public GameField(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
    }

    public void init(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[width][height].residents.add(new Wolf(i, j, 1, 1, 1, 1, null));
                //Holy shit, it's temporary.
            }
        }
    }
}
