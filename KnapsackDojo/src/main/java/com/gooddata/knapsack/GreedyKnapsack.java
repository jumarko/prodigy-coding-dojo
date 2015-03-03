package com.gooddata.knapsack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
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
                (i1, i2) -> {
                    int diff = i2.getValue() - i1.getValue();
                    if (diff == 0) {
                        return i1.getWeight() - i2.getWeight();
                    } else {
                        return diff;
                    }
                }
        );
    }
}
