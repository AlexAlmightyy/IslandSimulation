package islandsimulation.Organism.Animals;

import islandsimulation.Organism.Animals.Herbivore.Boar;
import islandsimulation.Organism.Animals.Herbivore.Buffalo;
import islandsimulation.Organism.Animals.Herbivore.Caterpillar;
import islandsimulation.Organism.Animals.Herbivore.Deer;
import islandsimulation.Organism.Animals.Herbivore.Duck;
import islandsimulation.Organism.Animals.Herbivore.Goat;
import islandsimulation.Organism.Animals.Herbivore.Horse;
import islandsimulation.Organism.Animals.Herbivore.Mouse;
import islandsimulation.Organism.Animals.Herbivore.Rabbit;
import islandsimulation.Organism.Animals.Herbivore.Sheep;
import islandsimulation.Organism.Animals.Predator.Bear;
import islandsimulation.Organism.Animals.Predator.Boa;
import islandsimulation.Organism.Animals.Predator.Eagle;
import islandsimulation.Organism.Animals.Predator.Fox;
import islandsimulation.Organism.Animals.Predator.Wolf;
import islandsimulation.Organism.Organism;
import islandsimulation.Organism.Plants.Grass;

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
