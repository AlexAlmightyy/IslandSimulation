package islandSimulation.Organism.Animals;

import islandSimulation.Organism.Animals.Herbivore.Boar;
import islandSimulation.Organism.Animals.Herbivore.Buffalo;
import islandSimulation.Organism.Animals.Herbivore.Caterpillar;
import islandSimulation.Organism.Animals.Herbivore.Deer;
import islandSimulation.Organism.Animals.Herbivore.Duck;
import islandSimulation.Organism.Animals.Herbivore.Goat;
import islandSimulation.Organism.Animals.Herbivore.Horse;
import islandSimulation.Organism.Animals.Herbivore.Mouse;
import islandSimulation.Organism.Animals.Herbivore.Rabbit;
import islandSimulation.Organism.Animals.Herbivore.Sheep;
import islandSimulation.Organism.Animals.Predator.Bear;
import islandSimulation.Organism.Animals.Predator.Boa;
import islandSimulation.Organism.Animals.Predator.Eagle;
import islandSimulation.Organism.Animals.Predator.Fox;
import islandSimulation.Organism.Animals.Predator.Wolf;
import islandSimulation.Organism.Organism;
import islandSimulation.Organism.Plants.Grass;

import java.util.HashMap;
import java.util.Map;

public enum AnimalType {
    WOLF(Wolf.class),
    BOA(Boa.class),
    FOX(Fox.class),
    BEAR(Bear.class),
    EAGLE(Eagle.class),
    HORSE(Horse.class),
    DEER(Deer.class),
    RABBIT(Rabbit.class),
    MOUSE(Mouse.class),
    GOAT(Goat.class),
    SHEEP(Sheep.class),
    BOAR(Boar.class),
    BUFFALO(Buffalo.class),
    DUCK(Duck.class),
    GOOSE(Caterpillar.class),
    GRASS(Grass.class);

    private final Class<? extends Organism> organismClass;
    private static final Map<Class<? extends Organism>, AnimalType> classToTypeMap = new HashMap<>();

    static {
        for (AnimalType animalType : AnimalType.values()){
            classToTypeMap.put(animalType.getOrganismClass(), animalType);
        }
    }

    AnimalType(Class<? extends Organism> organismClass){
        this.organismClass = organismClass;
    }

    public Class<? extends Organism> getOrganismClass() {
        return organismClass;
    }

    public static <T extends Organism> AnimalType getTypeFromClass(Class<T> clazz){
        return classToTypeMap.get(clazz);
    }
}
