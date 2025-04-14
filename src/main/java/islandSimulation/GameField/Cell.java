package islandSimulation.GameField;

import islandSimulation.Organism.Organism;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cell {
    private int x;
    private int y;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }
    List<Organism> residents = new ArrayList<>();

    public void addOrganism(Organism organism){
        residents.add(organism);
    }

    public void removeOrganism(Organism organism) {
        residents.remove(organism);
    }

}
