package islandsimulation.Organism.Animals.Predator;

public class Boa extends Predator{
    public Boa() {
        super(15, 30, 1, 3);
        addEatChances("Wolf", 0);
        addEatChances("Boa", 0);
        addEatChances("Fox", 15);
        addEatChances("Bear", 0);
        addEatChances("Eagle", 0);
        addEatChances("Horse", 0);
        addEatChances("Deer", 0);
        addEatChances("Rabbit", 20);
        addEatChances("Mouse", 40);
        addEatChances("Goat", 0);
        addEatChances("Sheep", 0);
        addEatChances("Boar", 0);
        addEatChances("Buffalo", 0);
        addEatChances("Duck", 10);
        addEatChances("Caterpillar", 0);
        addEatChances("Grass", 0);
    }
}
