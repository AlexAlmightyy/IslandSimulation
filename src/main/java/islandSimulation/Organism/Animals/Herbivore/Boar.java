package islandSimulation.Organism.Animals.Herbivore;

public class Boar extends Herbivore{
    public Boar() {
        super(400, 50, 2, 50);
        addEatChances("Caterpillar", 90);
        addEatChances("Mouse", 50);
    }
}
