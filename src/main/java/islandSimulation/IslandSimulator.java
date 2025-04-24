package islandSimulation;

import islandSimulation.GameField.Cell;
import islandSimulation.GameField.GameField;
import islandSimulation.Organism.Animals.Animal;
import islandSimulation.Organism.Organism;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class IslandSimulator {
    private int tickCounter = 0;
    private final int maxTicks = 1000;
    private final GameField field;
    private final ScheduledExecutorService plantScheduler = Executors.newScheduledThreadPool(1);
    private final ExecutorService animalExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public IslandSimulator(GameField field){
        this.field = field;
        field.init();
    }

    public void start(){
        Cell[][] cells = field.getCells();
        plantScheduler.scheduleAtFixedRate(() -> {
            field.growPlants();
        }, 0, 2, TimeUnit.SECONDS);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                simulateAnimalsLife(cells);
                Thread.sleep(500);

                tickCounter++;
                System.out.println("Tick #" + tickCounter);
                StatisticService.printAnimalStatistic(field);
                if(isAllAnimalsDead()){
                    System.out.println("All animals DEAD. Simulation stoped");
                    break;
                }
                if(tickCounter >= maxTicks){
                    System.out.println("Reached tick limit. Simulation stoped");
                    break;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        shutdown();
    }

    private void shutdown() {
        plantScheduler.shutdown();
        animalExecutor.shutdown();
    }

    private void simulateAnimalsLife(Cell[][] cells) {
        List<Animal> allAnimals = new ArrayList<>();

        for (Cell[] row : cells) {
            for (Cell cell : row) {
                synchronized (cell){
                    for (Organism organism : cell.getResidentsCopy()) {
                        if(organism instanceof Animal animal){
                            allAnimals.add(animal);
                        }
                    }

                }
            }
        }

        try {
            runPhaseParallel(allAnimals, animal -> animal.move(field));
            runPhaseParallel(allAnimals, animal -> animal.eat(field));
            runPhaseParallel(allAnimals, animal -> animal.reproduce(field));
            runPhaseParallel(allAnimals, animal -> animal.setHasReproduced(false));
            runPhaseParallel(allAnimals, animal -> animal.deplete(field));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void runPhaseParallel(List<Animal> animals, AnimalAction action) throws InterruptedException {
        List<Callable<Void>> tasks = animals.stream()
                .map(animal -> (Callable<Void>) () -> {
                    action.perform(animal);
                    return null;
                }).toList();

        animalExecutor.invokeAll(tasks);
    }

    @FunctionalInterface
    interface AnimalAction {
        void perform(Animal animal);
    }

    private boolean isAllAnimalsDead(){
        return StatisticService.getTotalAnimalCount(field) == 0;
    }


}
