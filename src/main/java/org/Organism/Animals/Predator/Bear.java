package org.Organism.Animals.Predator;

import java.util.Map;

public class Bear extends Predator {

    public Bear(int x, int y, double weight, int maxNumPerCell, int speed, double foodNeed, Map<String, Double> eatChances) {
        super(x, y, weight, maxNumPerCell, speed, foodNeed, eatChances);
    }
}
