package com.gooddata.knapsack;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneticKnapsack extends Knapsack {
    public GeneticKnapsack(int size) {
        super(size);
    }

    @Override
    public List<Item> solve(Item... items) {
        final Random random = new Random();
        List<Item[]> generation = asList(genSolution(random, items),
                genSolution(random, items));

        printItems(generation);

        for (int i = 0; i < 10; i++) {
            // mutate
            mutate(random, generation, items);

            // cross
            final List<Item[]> cross = cross(generation, items.length);
            printItems(cross);

            // evaluate
            final ArrayList<Item[]> newGen = new ArrayList<>(generation);
            newGen.addAll(cross);
            final List<Item[]> evaluate = evaluate(newGen);

            generation = evaluate.subList(0, 2);
        }
        return stream(generation.get(0)).filter(i -> i != null).collect(Collectors.toList());
    }

    private void mutate(Random random, List<Item[]> generation, Item[] items) {
        if (random.nextBoolean()) {
            Item[] item = generation.get(random.nextInt(generation.size()));
            final int r1 = random.nextInt(item.length);
            item[r1] = item[r1] == null ? items[r1] : null;
        }
    }

    private void printItems(List<Item[]> generation) {
        System.out.println(generation.stream().map(Arrays::toString).collect(Collectors.toList()));
    }

    List<Item[]> cross(List<Item[]> generation, int itemsLength) {
        final Item[] items1 = generation.get(0);
        final Item[] items2 = generation.get(1);
        assert itemsLength == items1.length && itemsLength == items2.length;
        Item[] cross1 = new Item[itemsLength];
        Item[] cross2 = new Item[itemsLength];
        for (int j = 0; j < itemsLength; j++) {
            if (j < itemsLength / 2) {
                cross1[j] = items1[j];
                cross2[j] = items2[j];
            } else {
                cross1[j] = items2[j];
                cross2[j] = items1[j];
            }
        }

        return asList(cross1, cross2);
    }

    private Item[] genSolution(Random random, Item[] items) {
        return Arrays.stream(items)
                .map(item -> random.nextBoolean() ? item : null)
                .toArray(Item[]::new);
    }

    boolean isValid(Item[] solution) {
        return size >= asList(solution).stream().mapToInt(item -> item != null ? item.getWeight() : 0).sum();
    }

    List<Item[]> evaluate(List<Item[]> solutions) {
        return solutions.stream()
                .sorted(this::compare)
                .collect(Collectors.toList());
    }

    int compare(Item[] items1, Item[] items2) {
        final int totalValue2 = isValid(items2) ? getTotalValue(items2) : 0;
        final int totalValue1 = isValid(items1) ? getTotalValue(items1) : 0;
        return totalValue2 - totalValue1;
    }

    private int getTotalValue(Item[] s1) {
        return Arrays.stream(s1).mapToInt((item) -> item == null ? 0 : item.getValue()).sum();
    }
}
