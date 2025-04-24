package islandSimulation;

import islandSimulation.GameField.Cell;
import islandSimulation.GameField.GameField;
import islandSimulation.Organism.Animals.Animal;
import islandSimulation.Organism.Organism;
import islandSimulation.Organism.Plants.Grass;

import java.util.HashMap;
import java.util.Map;

public class StatisticService {
    private static Map<String, Integer> previousCounters = new HashMap<>();

    public static void printAnimalStatistic(GameField field){
        Map<String, Integer> currentCounters = new HashMap<>();
        countOrganisms(field, currentCounters);
        printStatistics(currentCounters);
        previousCounters = currentCounters;
        System.out.println(" =========================");
    }

    private static void printStatistics(Map<String, Integer> currentCounters) {
        System.out.println(" === Animal Statistics ===");
        for (Map.Entry<String, Integer> entry : currentCounters.entrySet()){
            String name = entry.getKey();
            int current = entry.getValue();
            int previous = previousCounters.getOrDefault(name, 0);
            int difference = current - previous;
            String differenceString = difference == 0 ? "(0)" : (difference > 0 ? "(+" + difference + ")" : "("+ difference + ")");
            System.out.printf("%s: %d %s\n", name, current, differenceString);
        }
    }

    private static void countOrganisms(GameField field, Map<String, Integer> currentCounters) {
        for(Cell[] row : field.getCells()){
            for (Cell cell : row) {
                for (Organism resident : cell.getResidentsCopy()) {
                    if(resident instanceof Animal animal){
                        String name = animal.getClass().getSimpleName();
                        currentCounters.put(name, currentCounters.getOrDefault(name, 0) + 1);
                    }
                    if(resident instanceof Grass grass){
                        String name = "Grass";
                        currentCounters.put(name, currentCounters.getOrDefault(name, 0) + 1);
                    }
                }
            }
        }
    }

    public static int getTotalAnimalCount(GameField field) {
        int totalCount = 0;
        for (Cell[] row : field.getCells()) {
            for (Cell cell : row) {
                synchronized (cell.getResidents()){
                    for (Organism organism : cell.getResidents()) {
                        if(organism instanceof Animal){
                            totalCount++;
                        }
                    }
                }
            }
        }
        return totalCount;
    }
}
