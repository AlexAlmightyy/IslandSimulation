package islandsimulation.Organism.Animals.Predator;

import islandsimulation.Organism.Animals.Animal;


public abstract class Predator extends Animal {

    public Predator(double weight, int maxCount, int speed, double foodNeed) {
        super(weight, maxCount, speed, foodNeed);
    }
}