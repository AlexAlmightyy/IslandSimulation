package islandSimulation.Organism.Animals;


import islandSimulation.Interfaces.Eatable;
import islandSimulation.Interfaces.Movable;
import islandSimulation.Interfaces.Reproducable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import islandSimulation.Organism.Organism;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Getter
public abstract class Animal extends Organism implements Movable, Reproducable, Eatable {
    private int x;
    private int y;
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


    public void eat(){

    }
    public void reproduce(){

    }

    public void move(){

    }

}
