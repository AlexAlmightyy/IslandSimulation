package islandSimulation;

import islandSimulation.GameField.Cell;
import islandSimulation.GameField.GameField;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class IslandSimulator {
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
                Thread.sleep(1000);
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
        for (Cell[] cell : cells) {
            for (Cell cell1 : cell) {
                animalExecutor.execute(() -> {
                    cell1.simulateResidents(field);
                });
            }
        }
    }


}
