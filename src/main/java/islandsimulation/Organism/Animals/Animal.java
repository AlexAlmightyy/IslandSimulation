package islandsimulation.Organism.Animals;


import islandsimulation.GameField.Cell;
import islandsimulation.GameField.GameField;
import islandsimulation.Interfaces.Depletion;
import islandsimulation.Interfaces.Eatable;
import islandsimulation.Interfaces.Movable;
import islandsimulation.Interfaces.Reproducable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import islandsimulation.Organism.Organism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@EqualsAndHashCode(callSuper = true)
@Getter
public class Animal extends Organism implements Movable, Reproducable, Eatable, Depletion {
    private final Gender gender;
    private final int speed;
    private final double foodNeed;
    private final Map<String, Double> eatChances = new HashMap<>();
    @Setter
    private boolean hasReproduced = false;

    public Animal(double weight,
                  int maxCount,
                  int speed,
                  double foodNeed) {
        super(weight, maxCount);
        this.gender = ThreadLocalRandom.current().nextBoolean() ? Gender.MALE : Gender.FEMALE;
        this.speed = speed;
        this.foodNeed = foodNeed;
    }

    public void addEatChances(String name, double chances) {
        this.eatChances.put(name, chances);
    }

    public double getEatChances(Organism prey) {
        String prayName = prey.getClass().getSimpleName();
        return eatChances.getOrDefault(prayName, 0.0);
    }

    public void eat(GameField field) {
        Cell currentCell = field.getCells()[this.getX()][this.getY()];
        List<Organism> currentCellResidents = currentCell.getResidents();
        Organism prey = getPrey(currentCellResidents);
        if (prey == null) return;
        eatThePrey(prey, currentCellResidents);
    }

    private void eatThePrey(Organism prey, List<Organism> currentCellResidents) {
        int currentChance = ThreadLocalRandom.current().nextInt(100);
        if (currentChance <= getEatChances(prey) && currentChance > 0) {
            if (prey.getWeight() >= this.foodNeed) {
                this.setWeight(this.getWeight() + this.foodNeed);
            } else {
                this.setWeight(this.getWeight() + prey.getWeight());
            }
            currentCellResidents.remove(prey);
        }
    }

    private Organism getPrey(List<Organism> currentCellResidents) {
        List<Organism> others = currentCellResidents.stream()
                .filter(o -> o != this)
                .toList();
        if (others.isEmpty()) {
            return null;
        }
        return others.get(ThreadLocalRandom.current().nextInt(others.size()));
    }

    public void reproduce(GameField field) {
        if (hasReproduced) return;
        Cell currentCell = field.getCells()[this.getX()][this.getY()];
        List<Animal> potentialPartners = getPotentialPartners(currentCell);
        if (potentialPartners.isEmpty()) return;
        Animal partner = potentialPartners.get(ThreadLocalRandom.current().nextInt(potentialPartners.size()));
        makeReproduction(currentCell);
        this.setHasReproduced(true);
        partner.setHasReproduced(true);
    }

    private void makeReproduction(Cell currentCell) {
        int offspringCount = ThreadLocalRandom.current().nextInt(1, 3);
        for (int i = 0; i < offspringCount; i++) {
            if (AnimalSupportService.getCountOfAnimalInCell(currentCell, this) < this.getMaxCount()) {
                try {
                    Animal child = this.getClass().getDeclaredConstructor().newInstance();
                    currentCell.addOrganism(child);
                    child.setCoordinates(this.getX(), this.getY());
                } catch (Exception e) {
                    System.err.println("Error while making a offspring for " + this.getClass().getSimpleName() + ": " + e.getMessage());
                }
            }
        }
    }

    private List<Animal> getPotentialPartners(Cell currentCell) {
        List<Organism> residents = currentCell.getResidentsCopy();
        return new ArrayList<>(residents).stream()
                .filter(o -> o instanceof Animal)
                .map(o -> (Animal) o)
                .filter(this::isValidToReproduce)
                .toList();
    }

    private boolean isValidToReproduce(Animal secondAnimal) {
        return this.getClass() == secondAnimal.getClass()
                && this != secondAnimal
                && this.gender != secondAnimal.gender
                && !secondAnimal.hasReproduced;
    }


    public void move(GameField field) {
        int timesToMove = speed > 0 ? ThreadLocalRandom.current().nextInt(speed) : 0;
        for (int i = 0; i < timesToMove; i++) {
            int[] newCoordinates = AnimalSupportService.getNewCoordinates(this.getX(), this.getY());
            if (AnimalSupportService.isCoordinatesValid(newCoordinates[0], newCoordinates[1], field)) {
                this.setCoordinates(newCoordinates[0], newCoordinates[1]);
                field.getCells()[newCoordinates[0]][newCoordinates[1]].addOrganism(this);
                field.getCells()[this.getX()][this.getY()].removeOrganism(this);
            }
        }
    }

    @Override
    public void deplete(GameField field) {
        this.setWeight(this.getWeight() - this.foodNeed);
        if (this.getWeight() <= 0) {
            field.getCells()[this.getX()][this.getY()].removeOrganism(this);
        }
    }
}