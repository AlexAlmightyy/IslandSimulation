package org.Organism.Animals;


import org.Interfaces.Eatable;
import org.Interfaces.Movable;
import org.Interfaces.Reproducable;
import org.Organism.Organism;
import java.util.HashMap;
import java.util.Map;

public abstract class Animal implements Organism, Movable, Reproducable, Eatable {
    private int x;
    private int y;
    private double weight;
    private int maxNumPerCell;
    private int speed;
    private double foodNeed;
    private Map<String, Double> eatChances = new HashMap<>();

    public Animal(int x, int y, double weight, int maxNumPerCell, int speed, double foodNeed, Map<String, Double> eatChances) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.maxNumPerCell = maxNumPerCell;
        this.speed = speed;
        this.foodNeed = foodNeed;
        this.eatChances = eatChances;
    }

    public void eat(){

    }
    public void reproduce(){

    }

    public void move(){

    }

}
