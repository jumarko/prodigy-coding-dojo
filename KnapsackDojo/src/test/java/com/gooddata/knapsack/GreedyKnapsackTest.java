package com.gooddata.knapsack;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class GreedyKnapsackTest {

    private Knapsack knapsack;

    @Before
    public void setUp() throws Exception {
        knapsack = new GreedyKnapsack(30);

    }

    @Test
    public void testSimple() throws Exception {
        final Item item = new Item(30);
        assertThat( knapsack.solve(item), Matchers.contains(item));
    }

    @Test
    public void testMore() throws Exception {
        final Item item1 = new Item(11);
        final Item item2 = new Item(20);
        assertThat( knapsack.solve(item1, item2), Matchers.contains(item1));
    }

    @Test
    public void testMoreIndifferentOrder() throws Exception {
        final Item item1 = new Item(20);
        final Item item2 = new Item(11);
        assertThat( knapsack.solve(item1, item2), Matchers.contains(item2));
    }

    @Test
    public void testMoreIndifferentOrder1() throws Exception {
        final Item item1 = new Item(35);
        final Item item2 = new Item(2);
        final Item item3 = new Item(20);
        final Item item4 = new Item(9);
        final Item item5 = new Item(3);
        final Item item6 = new Item(11);
        assertThat( knapsack.solve(item1, item2, item3, item4, item5, item6),
                Matchers.containsInAnyOrder(item2, item4, item5, item6));
    }

    @Test
    public void testDiffValue() throws Exception {
        final Item item1 = new Item(20, 2);
        final Item item2 = new Item(11, 1);
        assertThat( knapsack.solve(item1, item2), Matchers.contains(item1));
    }

    /**
     * Following tests will always fail when using Greedy algorithm.
     */
    @Test
    public void testDiffValue2() throws Exception {
        final Item item1 = new Item(29, 4);
        final Item item2 = new Item(5, 2);
        final Item item3 = new Item(4, 3);
        assertThat( knapsack.solve(item1, item2, item3), Matchers.containsInAnyOrder(item2, item3));
    }


}