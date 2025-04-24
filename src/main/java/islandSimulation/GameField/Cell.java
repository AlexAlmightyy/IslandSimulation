package islandSimulation.GameField;

import islandSimulation.Organism.Animals.Animal;
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

    public List<Organism> getResidentsCopy() {
        return new ArrayList<>(residents);
    }

    List<Organism> residents = new ArrayList<>();

    public synchronized void addOrganism(Organism organism){
        residents.add(organism);
    }

    public synchronized void removeOrganism(Organism organism) {
        residents.remove(organism);
    }

    public synchronized void simulateResidents(GameField field){
        List<Organism> copyOfResidents = new ArrayList<>(residents);
        for (Organism resident : copyOfResidents) {
            if(resident instanceof Animal animal){
                animal.move(field);
                animal.eat(field);
                animal.reproduce(field);
                animal.deplete(field);
            }
        }
    }

}
