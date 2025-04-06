package org.Organism.Animals.Predator;

import java.util.Map;

public class Wolf extends Predator{
    public Wolf(int x, int y, double weight, int maxNumPerCell, int speed, double foodNeed, Map<String, Double> eatChances) {
        super(x, y, weight, maxNumPerCell, speed, foodNeed, eatChances);
    }

}
