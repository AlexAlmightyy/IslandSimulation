package islandsimulation;

import islandsimulation.GameField.GameField;

public class Main {
    public static void main(String[] args) {
        GameField gameField = new GameField(10, 10);
        IslandSimulator islandSimulator = new IslandSimulator(gameField);
        islandSimulator.start();
    }
}