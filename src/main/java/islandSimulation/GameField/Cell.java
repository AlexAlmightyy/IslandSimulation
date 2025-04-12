package islandSimulation.GameField;

import islandSimulation.Organism.Organism;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cell {
    int x;
    int y;

    List<Organism> residents = new ArrayList<>();

    public void addOrganism(Organism organism){
        residents.add(organism);
    }

}
