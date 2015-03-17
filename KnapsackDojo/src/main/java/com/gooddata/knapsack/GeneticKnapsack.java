package com.gooddata.knapsack;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO
 */
public class GeneticKnapsack extends Knapsack {
    public GeneticKnapsack(int size) {
        super(size);
    }

    @Override
    public List<Item> solve(Item... items) {
        final Random random = new Random();
        List<Item[]> generation = asList(genSolution(random, items),
                genSolution(random, items));

        System.out.println(generation.stream().map(Arrays::toString).collect(Collectors.toList()));

        for (int i = 0; i < 10; i++) {

            // cross
            // mutate
            // evaluate

        }
        return null;
    }

    private Item[] genSolution(Random random, Item[] items) {
        return Arrays.stream(items).filter(i -> random.nextBoolean()).toArray(Item[]::new);
    }

    boolean isValid(Item[] solution) {
        return size >= asList(solution).stream().mapToInt(Item::getWeight).sum();
    }

    List<Item[]> evaluate(List<Item[]> solutions) {
        return solutions.stream()
                .filter(this::isValid)
                .sorted((s1,s2) -> getTotalValue(s2) - getTotalValue(s1))
                .collect(Collectors.toList());
    }

    private int getTotalValue(Item[] s1) {
        return Arrays.stream(s1).mapToInt(Item::getValue).sum();
    }
}
