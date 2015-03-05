package com.gooddata.knapsack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of Greedy algorithm for 0-1 Knapsack problem.
 */
public class GreedyKnapsack extends Knapsack {
    public GreedyKnapsack(int size) {
        super(size);
    }

    @Override
    public List<Item> solve(Item... items) {
        final ArrayList<Item> result = new ArrayList<>();

        sortItems(items);

        int weight = 0;
        for (Item item : items) {
            if (weight + item.getWeight() > size) {
                break;
            }
            weight += item.getWeight();
            result.add(item);
        }
        return result;
    }

    private void sortItems(Item[] items) {
        Arrays.sort(items,
                Comparator.comparing(Item::getValue).reversed() // prefer highest-value items
                        .thenComparing(Item::getWeight)); // prefer lightest items
    }
}
