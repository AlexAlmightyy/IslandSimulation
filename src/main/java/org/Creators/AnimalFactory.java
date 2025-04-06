package org.Creators;

import org.Organism.Animals.Animal;
import org.Organism.Animals.Predator.Wolf;

public class AnimalFactory {

    public static Animal createAnimal(AnimalConfig config){
        return new Wolf(1,1,1,1,1,1,null);
        //temporary
    }
}
