package islandsimulation.Organism.Animals.Herbivore;

public class Duck extends Herbivore{

    public Duck() {
        super(1, 200, 4, 0.15);
        addEatChances("Caterpillar", 90);
    }
}
