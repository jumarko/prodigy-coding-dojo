package com.gooddata.knapsack;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class GeneticKnapsackTest {

    private GeneticKnapsack knapsack;

    @Before
    public void setUp() throws Exception {
        knapsack = new GeneticKnapsack(30);

    }

    @Test
    public void testIsValid() throws Exception {
        assertTrue(knapsack.isValid(new Item[] { new Item(30) }));
        assertFalse(knapsack.isValid(new Item[] { new Item(32) }));

    }

    @Test
    public void testEvaluate() throws Exception {
        assertThat(knapsack.evaluate(Arrays.asList(
                new Item[] { new Item(30) },
                new Item[] { new Item(28), new Item(3) },
                new Item[] { new Item(1), new Item(2), new Item(18) },
                new Item[] { new Item(10), new Item(19) }
        )), contains(
                new Item[] { new Item(1), new Item(2), new Item(18) },
                new Item[] { new Item(10), new Item(19) },
                new Item[] { new Item(30) },
                new Item[] { new Item(28), new Item(3)}
        ));

    }

    @Test
    public void testCross() throws Exception {
        assertThat(knapsack.cross(Arrays.asList(new Item[]{new Item(1), null, new Item(2), new Item(18)},
                        new Item[]{new Item(1), new Item(2), null, new Item(18)}), 4),
                contains(new Item[]{new Item(1), null, null, new Item(18)},
                        new Item[] { new Item(1), new Item(2), new Item(2), new Item(18) }));

    }

    @Test
    public void testSimple() throws Exception {
        final Item item = new Item(30);
        assertThat( knapsack.solve(item), contains(item));
    }

    @Test
    public void testMore() throws Exception {
        final Item item1 = new Item(11);
        final Item item2 = new Item(20);
        assertThat( knapsack.solve(item1, item2), contains(item1));
    }

    @Test
    public void testMoreIndifferentOrder() throws Exception {
        final Item item1 = new Item(20);
        final Item item2 = new Item(11);
        assertThat( knapsack.solve(item1, item2), contains(item2));
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
        assertThat( knapsack.solve(item1, item2), contains(item1));
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