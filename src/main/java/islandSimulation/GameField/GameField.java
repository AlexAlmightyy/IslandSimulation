package islandSimulation.GameField;


import islandSimulation.Organism.Organism;
import islandSimulation.Organism.Plants.Grass;
import lombok.Getter;
import islandSimulation.Organism.Animals.Herbivore.*;
import islandSimulation.Organism.Animals.Predator.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

@Getter
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
//                initPredators(i, j);
                initHerbivores(i, j);
                initPlants(i, j);
            }
        }
    }

    private void initPlants(int i, int j) {
        addManyOrganism(cells[i][j], Grass::new, ThreadLocalRandom.current().nextInt(200));
    }

    private void initHerbivores(int i, int j) {
        addManyOrganism(cells[i][j], Boar::new, ThreadLocalRandom.current().nextInt(50));
        addManyOrganism(cells[i][j], Buffalo::new, ThreadLocalRandom.current().nextInt(10));
        addManyOrganism(cells[i][j], Caterpillar::new, ThreadLocalRandom.current().nextInt(1000));
        addManyOrganism(cells[i][j], Deer::new, ThreadLocalRandom.current().nextInt(20));
        addManyOrganism(cells[i][j], Duck::new, ThreadLocalRandom.current().nextInt(200));
        addManyOrganism(cells[i][j], Goat::new, ThreadLocalRandom.current().nextInt(140));
        addManyOrganism(cells[i][j], Horse::new, ThreadLocalRandom.current().nextInt(20));
        addManyOrganism(cells[i][j], Mouse::new, ThreadLocalRandom.current().nextInt(500));
        addManyOrganism(cells[i][j], Rabbit::new, ThreadLocalRandom.current().nextInt(150));
        addManyOrganism(cells[i][j], Sheep::new, ThreadLocalRandom.current().nextInt(140));

    }

    private void initPredators(int i, int j) {
        addManyOrganism(cells[i][j], Wolf::new, ThreadLocalRandom.current().nextInt(30));
        addManyOrganism(cells[i][j], Fox::new, ThreadLocalRandom.current().nextInt(30));
        addManyOrganism(cells[i][j], Bear::new, ThreadLocalRandom.current().nextInt(5));
        addManyOrganism(cells[i][j], Boa::new, ThreadLocalRandom.current().nextInt(30));
        addManyOrganism(cells[i][j], Eagle::new, ThreadLocalRandom.current().nextInt(20));
    }

    private void addManyOrganism(Cell cell, Supplier<Organism> factory, int count){
        for (int i = 0; i < count; i++) {
            cell.addOrganism(factory.get());
        }
    }

    public void printAllOrganismsInCell(int x, int y){
        cells[x][y].residents.forEach(System.out::println);
    }

    public void printAllCells(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                printAllOrganismsInCell(i, j);
            }
        }
    }
}
