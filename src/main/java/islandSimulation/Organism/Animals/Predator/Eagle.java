package islandSimulation.Organism.Animals.Predator;

public class Eagle extends Predator{
    public Eagle() {
        super(6, 20, 3, 1);
        addEatChances("Wolf", 0);
        addEatChances("Boa", 0);
        addEatChances("Fox", 10);
        addEatChances("Bear", 0);
        addEatChances("Eagle", 0);
        addEatChances("Horse", 0);
        addEatChances("Deer", 0);
        addEatChances("Rabbit", 90);
        addEatChances("Mouse", 90);
        addEatChances("Goat", 0);
        addEatChances("Sheep", 0);
        addEatChances("Boar", 0);
        addEatChances("Buffalo", 0);
        addEatChances("Duck", 80);
        addEatChances("Caterpillar", 0);
        addEatChances("Grass", 0);
    }
}
