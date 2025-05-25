package islandsimulation.GameField;

import islandsimulation.Organism.Organism;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cell {
    private int x;
    private int y;

    Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    List<Organism> residents = new ArrayList<>();

    public List<Organism> getResidentsCopy() {
        return new ArrayList<>(residents);
    }

    public synchronized void addOrganism(Organism organism){
        residents.add(organism);
    }

    public synchronized void removeOrganism(Organism organism) {
        residents.remove(organism);
    }
}
