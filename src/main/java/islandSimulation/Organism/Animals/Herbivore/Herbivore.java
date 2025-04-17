package islandSimulation.Organism.Animals.Herbivore;

import islandSimulation.Organism.Animals.Animal;

public abstract class Herbivore extends Animal {

    public Herbivore(double weight, int maxCount, int speed, double foodNeed) {
        super(weight, maxCount, speed, foodNeed);
        addEatChances("Grass", 100);
    }
}
