package islandsimulation.Organism.Animals.Herbivore;

public class Mouse extends Herbivore{
    public Mouse() {
        super(0.05, 500, 1, 0.01);
        addEatChances("Caterpillar", 90);
    }
}
