package islandSimulation.Organism.Animals;


import islandSimulation.GameField.Cell;
import islandSimulation.GameField.GameField;
import islandSimulation.Interfaces.Depletion;
import islandSimulation.Interfaces.Eatable;
import islandSimulation.Interfaces.Movable;
import islandSimulation.Interfaces.Reproducable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import islandSimulation.Organism.Organism;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@EqualsAndHashCode(callSuper = true)
@Getter
public class Animal extends Organism implements Movable, Reproducable, Eatable, Depletion {
    private int speed;
    private double foodNeed;
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

    public void addEatChances(String name, double chances){
        this.eatChances.put(name, chances);
    }

    public double getEatChances(Organism prey){
        String prayName = prey.getClass().getSimpleName();
        return eatChances.getOrDefault(prayName, 0.0);
    }


    public void eat(GameField field) {
        Cell currentCell = field.getCells()[this.getX()][this.getY()];
        List<Organism> currentCellResidents = currentCell.getResidents();
        Organism prey = currentCellResidents.get(ThreadLocalRandom.current().nextInt(currentCellResidents.size()));
        int currentChance = ThreadLocalRandom.current().nextInt(100);
        if(currentChance <= getEatChances(prey) && currentChance > 0){
            if(prey.getWeight() >= this.foodNeed){
                this.setWeight(this.getWeight() + this.foodNeed);
            }else{
                this.setWeight(this.getWeight() + prey.getWeight());
            }
            currentCellResidents.remove(prey);
        }
    }

    public void reproduce() {

    }


    public void move(GameField field) {
        int timesToMove = ThreadLocalRandom.current().nextInt(speed);
        for (int i = 0; i < timesToMove; i++) {
            int[] newCoordinates = AnimalSupportService.getNewCoordinates(this.getX(), this.getY());
            if(AnimalSupportService.isCoordinatesValidToMove(newCoordinates[0], newCoordinates[1], field)){
                field.getCells()[this.getX()][this.getY()].removeOrganism(this);
                this.setCoordinates(newCoordinates[0], newCoordinates[1]);
                field.getCells()[newCoordinates[0]][newCoordinates[1]].addOrganism(this);
            }
        }
    }

    @Override
    public void deplete(GameField field) {
        this.setWeight(this.getWeight() - this.foodNeed);
        if(this.getWeight() <= 0){
            field.getCells()[this.getX()][this.getY()].removeOrganism(this);
        }
    }
}
