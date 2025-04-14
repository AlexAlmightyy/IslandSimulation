package islandSimulation.Organism;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@EqualsAndHashCode
public abstract class Organism{
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private int x;
    private int y;
    private final int id;
    private double weight;
    private final int maxCount;

    public Organism(double weight, int maxCount){
        this.id = idCounter.getAndIncrement();
        this.weight = weight;
        this.maxCount = maxCount;
    }

    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Organism{" +
                "Type" + this.getClass().getName() +
                " x=" + x +
                ", y=" + y +
                ", id=" + id +
                ", weight=" + weight +
                ", maxCount=" + maxCount +
                '}';
    }
}