package islandSimulation;

import islandSimulation.GameField.GameField;

public class Main {

    public static void main(String[] args) {
        GameField gameField = new GameField(10, 10);
        gameField.init();
        gameField.printAllCells();
    }
}
