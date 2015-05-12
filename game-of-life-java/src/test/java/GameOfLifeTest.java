import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameOfLifeTest {

    GameOfLife gameOfLife;

    @Test
    public void stillLife() {

        final Set<Cell> first = new HashSet<>(asList(new Cell(2, 2), new Cell(2, 3), new Cell(3, 2), new Cell(3, 3)));
        gameOfLife = new GameOfLife(first);

        final Set<Cell> nextGen = gameOfLife.nextGeneration();
        assertThat(nextGen, is(first));
    }

    @Test
    public void oscilator() {
        final Set<Cell> first = new HashSet<>(asList(new Cell(2, 1), new Cell(2, 2), new Cell(2, 3)));
        gameOfLife = new GameOfLife(first);

        final Set<Cell> nextGen = gameOfLife.nextGeneration();
        assertThat(nextGen, is(new HashSet<>(asList(new Cell(1, 2), new Cell(2, 2), new Cell(3, 2)))));
    }

    @Test
    public void allAffectedCells() {
        final Set<Cell> first = new HashSet<>(asList(new Cell(2, 1), new Cell(2, 2), new Cell(2, 3)));
        gameOfLife = new GameOfLife(first);

        assertThat(gameOfLife.getAffectedCells(), is(new HashSet<>(asList(
                new Cell(1,0), new Cell(2,0), new Cell(3,0),
                new Cell(1,1), new Cell(2,1), new Cell(3,1),
                new Cell(1,2), new Cell(2,2), new Cell(3,2),
                new Cell(1,3), new Cell(2,3), new Cell(3,3),
                new Cell(1,4), new Cell(2,4), new Cell(3,4)
        ))));
    }

    /**
     * Check http://en.wikipedia.org/wiki/File:Game_of_life_animated_glider.gif.
     */
    @Test
    public void glider() {
        final Set<Cell> firstGen = new HashSet<>(
                asList(new Cell(1, 3), new Cell(2, 3), new Cell(3, 3), new Cell(3, 2), new Cell(2, 1))
        );
        gameOfLife = new GameOfLife(firstGen);

        assertThat(gameOfLife.nextGeneration(), is(new HashSet<>(asList(
                new Cell(1, 2), new Cell(3, 2), new Cell(2, 3), new Cell(3, 3), new Cell(2, 4)))));

        assertThat(gameOfLife.nextGeneration(), is(new HashSet<>(asList(
                new Cell(3, 2), new Cell(1, 3), new Cell(3, 3), new Cell(2, 4), new Cell(3, 4)))));

        assertThat(gameOfLife.nextGeneration(), is(new HashSet<>(asList(
                new Cell(2, 2), new Cell(3, 3), new Cell(4, 3), new Cell(2, 4), new Cell(3, 4)))));

        assertThat(gameOfLife.nextGeneration(), is(new HashSet<>(asList(
                new Cell(3, 2), new Cell(4, 3), new Cell(2, 4), new Cell(3, 4), new Cell(4, 4)))));


    }
}