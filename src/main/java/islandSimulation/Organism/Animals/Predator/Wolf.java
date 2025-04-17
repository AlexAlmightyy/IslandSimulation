package islandSimulation.Organism.Animals.Predator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Wolf extends Predator{
    public Wolf() {
        super(50, 30, 3, 8);
        addEatChances("Boa", 0);
        addEatChances("Fox", 0);
        addEatChances("Bear", 0);
        addEatChances("Eagle", 0);
        addEatChances("Wolf", 0);
        addEatChances("Horse", 10);
        addEatChances("Deer", 15);
        addEatChances("Rabbit", 60);
        addEatChances("Mouse", 80);
        addEatChances("Goat", 60);
        addEatChances("Sheep", 70);
        addEatChances("Boar", 15);
        addEatChances("Buffalo", 10);
        addEatChances("Duck", 40);
        addEatChances("Caterpillar", 0);
        addEatChances("Grass", 0);
    }



}
