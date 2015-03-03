package com.gooddata.knapsack;

import java.util.List;

/**
 * Base class for knapsack solvers
 */
public abstract class Knapsack {

    protected int size;

    public Knapsack(int size) {
        this.size = size;
    }

    public abstract List<Boolean> solve(List<Integer> things);
}
