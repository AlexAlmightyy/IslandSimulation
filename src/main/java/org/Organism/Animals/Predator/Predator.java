package org.Organism.Animals.Predator;

import org.Organism.Animals.Animal;

import java.util.Map;

public abstract class Predator extends Animal {
    public Predator(int x, int y, double weight, int maxNumPerCell, int speed, double foodNeed, Map<String, Double> eatChances) {
        super(x, y, weight, maxNumPerCell, speed, foodNeed, eatChances);
    }
}
