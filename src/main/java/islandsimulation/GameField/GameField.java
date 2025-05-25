package islandsimulation.GameField;


import islandsimulation.Organism.Organism;
import islandsimulation.Organism.Plants.Grass;
import islandsimulation.Organism.Plants.Plant;
import lombok.Getter;
import islandsimulation.Organism.Animals.Herbivore.*;
import islandsimulation.Organism.Animals.Predator.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

@Getter
public class GameField {
    private int width;
    private int height;

    public synchronized Cell[][] getCells() {
        return cells;
    }

    private Cell[][] cells;

    public GameField(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
    }

    public void init() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(i, j);
                initPredators(i, j);
                initHerbivores(i, j);
            }
        }
        initPlants();
    }

    private void initPlants() {
        growPlants();
    }

    private void initHerbivores(int i, int j) {
        addManyOrganism(cells[i][j], Boar::new, ThreadLocalRandom.current().nextInt(20));
        addManyOrganism(cells[i][j], Buffalo::new, ThreadLocalRandom.current().nextInt(4));
        addManyOrganism(cells[i][j], Caterpillar::new, ThreadLocalRandom.current().nextInt(200));
        addManyOrganism(cells[i][j], Deer::new, ThreadLocalRandom.current().nextInt(8));
        addManyOrganism(cells[i][j], Duck::new, ThreadLocalRandom.current().nextInt(80));
        addManyOrganism(cells[i][j], Goat::new, ThreadLocalRandom.current().nextInt(56));
        addManyOrganism(cells[i][j], Horse::new, ThreadLocalRandom.current().nextInt(8));
        addManyOrganism(cells[i][j], Mouse::new, ThreadLocalRandom.current().nextInt(200));
        addManyOrganism(cells[i][j], Rabbit::new, ThreadLocalRandom.current().nextInt(60));
        addManyOrganism(cells[i][j], Sheep::new, ThreadLocalRandom.current().nextInt(56));

    }

    private void initPredators(int i, int j) {
        addManyOrganism(cells[i][j], Wolf::new, ThreadLocalRandom.current().nextInt(12));
        addManyOrganism(cells[i][j], Fox::new, ThreadLocalRandom.current().nextInt(12));
        addManyOrganism(cells[i][j], Bear::new, ThreadLocalRandom.current().nextInt(2));
        addManyOrganism(cells[i][j], Boa::new, ThreadLocalRandom.current().nextInt(12));
        addManyOrganism(cells[i][j], Eagle::new, ThreadLocalRandom.current().nextInt(8));
    }

    public void growPlants() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                int grassCountInCurrCell = (int) cells[i][j].getResidentsCopy().stream().filter(o -> o instanceof Plant).count();
                addManyOrganism(cells[i][j], Grass::new, ThreadLocalRandom.current().nextInt(200 - grassCountInCurrCell));
            }
        }
    }

    private <T extends Organism> void addManyOrganism(Cell cell, Supplier<T> factory, int count) {
        for (int i = 0; i < count; i++) {
            T organism = factory.get();
            organism.setCoordinates(cell.getX(), cell.getY());
            cell.addOrganism(organism);
        }
    }

    public void printAllOrganismsInCell(int x, int y) {
        cells[x][y].residents.forEach(System.out::println);
    }

    public void printAllCells() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                printAllOrganismsInCell(i, j);
            }
        }
    }
}