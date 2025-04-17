package islandSimulation.Organism.Animals.Predator;

public class Bear extends Predator {
    public Bear() {
        super(500, 5, 2, 80);
        addEatChances("Wolf", 0);
        addEatChances("Boa", 80);
        addEatChances("Fox", 0);
        addEatChances("Bear", 0);
        addEatChances("Eagle", 0);
        addEatChances("Horse", 40);
        addEatChances("Deer", 80);
        addEatChances("Rabbit", 80);
        addEatChances("Mouse", 90);
        addEatChances("Goat", 70);
        addEatChances("Sheep", 70);
        addEatChances("Boar", 50);
        addEatChances("Buffalo", 20);
        addEatChances("Duck", 10);
        addEatChances("Caterpillar", 0);
        addEatChances("Grass", 0);
    }
}
