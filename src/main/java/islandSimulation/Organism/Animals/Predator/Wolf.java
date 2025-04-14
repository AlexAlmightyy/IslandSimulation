package islandSimulation.Organism.Animals.Predator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Wolf extends Predator{
    public Wolf() {
        super(50, 30, 3, 8);
    }

}
