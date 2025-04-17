package islandSimulation.Organism.Animals.Predator;

public class Fox extends Predator{
    public Fox() {
        super(8, 30, 2, 2);
        addEatChances("Wolf", 0);
        addEatChances("Boa", 0);
        addEatChances("Fox", 0);
        addEatChances("Bear", 0);
        addEatChances("Eagle", 0);
        addEatChances("Horse", 0);
        addEatChances("Deer", 0);
        addEatChances("Rabbit", 70);
        addEatChances("Mouse", 90);
        addEatChances("Goat", 0);
        addEatChances("Sheep", 0);
        addEatChances("Boar", 0);
        addEatChances("Buffalo", 0);
        addEatChances("Duck", 60);
        addEatChances("Caterpillar", 40);
        addEatChances("Grass", 0);
    }
}
