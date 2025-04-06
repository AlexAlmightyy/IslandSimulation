package org.Organism.Animals.Herbivore;

import java.util.Map;

public class Duck extends Herbivore{
    public Duck(int x, int y, double weight, int maxNumPerCell, int speed, double foodNeed, Map<String, Double> eatChances) {
        super(x, y, weight, maxNumPerCell, speed, foodNeed, eatChances);
    }
}
