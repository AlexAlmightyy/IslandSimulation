package islandSimulation.Organism.Animals;

import islandSimulation.GameField.Cell;
import islandSimulation.GameField.GameField;
import islandSimulation.Organism.Organism;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalSupportService {

    static int[] getNewCoordinates(int x, int y) {
        /*This method will return coordinates to move ONLY for 1 cell in random direction*/
        int newX = x;
        int newY = y;
        int direction = ThreadLocalRandom.current().nextInt(4);
        switch (direction) {
            case 0 -> newX -= 1;
            case 1 -> newX += 1;
            case 2 -> newY -= 1;
            case 3 -> newY += 1;
        }
        return new int[]{newX, newY};
    }

    public static boolean isCoordinatesValid(int x, int y, GameField field) {
        return x >= 0 && y >= 0 && x < field.getWidth() && y < field.getHeight();
    }

    public static int getCountOfAnimalInCell(Cell cell, Organism organism){
        List<Organism> residents = new ArrayList<>(cell.getResidentsCopy());
        int count = 0;
        for (Organism resident : residents) {
            if(resident != null && resident.getClass().equals(organism.getClass())){
                count++;
            }
        }
        return count;
    }




}
