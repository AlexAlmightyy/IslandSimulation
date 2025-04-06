package org.GameField;

import org.Organism.Organism;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Cell {
    int x;
    int y;

    List<Organism> residents = new ArrayList<>();
}
