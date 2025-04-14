package islandSimulation.Organism.Animals;


import islandSimulation.GameField.Cell;
import islandSimulation.GameField.GameField;
import islandSimulation.Interfaces.Eatable;
import islandSimulation.Interfaces.Movable;
import islandSimulation.Interfaces.Reproducable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import islandSimulation.Organism.Organism;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@EqualsAndHashCode(callSuper = true)
@Getter
public class Animal extends Organism implements Movable, Reproducable, Eatable {
    private int speed;
    private double foodNeed;
    @Setter
    private Map<String, Double> eatChances = new HashMap<>();
    @Setter
    private boolean hasReproduced = false;

    public Animal(double weight,
                  int maxCount,
                  int speed,
                  double foodNeed) {
        super(weight, maxCount);
        this.speed = speed;
        this.foodNeed = foodNeed;
    }


    public void eat() {

    }

    public void reproduce() {

    }


    public void move(GameField field) {
        int timesToMove = ThreadLocalRandom.current().nextInt(speed);
        for (int i = 0; i < timesToMove; i++) {
            int[] newCoordinates = AnimalSupportService.getNewCoordinates(getX(), getY());
            if(AnimalSupportService.isCoordinatesValidToMove(newCoordinates[0], newCoordinates[1], field)){
                field.getCells()[getX()][getY()].removeOrganism(this);
                this.setCoordinates(newCoordinates[0], newCoordinates[1]);
                field.getCells()[newCoordinates[0]][newCoordinates[1]].addOrganism(this);
            }
        }
    }
}
