package org.Organism.Animals.Herbivore;

import org.Organism.Animals.Animal;

import java.util.Map;

public abstract class Herbivore extends Animal {
    public Herbivore(int x, int y, double weight, int maxNumPerCell, int speed, double foodNeed, Map<String, Double> eatChances) {
        super(x, y, weight, maxNumPerCell, speed, foodNeed, eatChances);
    }
}
