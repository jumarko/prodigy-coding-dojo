import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {

    private Set<Cell> generation = new HashSet<>();

    public GameOfLife(Set<Cell> firstGeneration) {
        this.generation.addAll(firstGeneration);
    }

    public Set<Cell> nextGeneration() {
        final Set<Cell> affectedCells = getAffectedCells();

        generation = affectedCells.stream().filter(this::shouldLive).collect(Collectors.toSet());
        return generation;
    }

    public boolean shouldLive(Cell cell) {
        final long count = getNeighbours(cell).filter(this::isAlive).count();
        return (count == 2 && isAlive(cell)) || count == 3;
    }

    private boolean isAlive(Cell c) {
        return generation.contains(c);
    }

    Set<Cell> getAffectedCells() {
        return generation.stream().flatMap(GameOfLife::getNeighbours)
                .collect(Collectors.toSet());
    }

    private static Stream<Cell> getNeighbours(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();

        return Arrays.stream(new Cell[] {
                new Cell(x-1,y-1), new Cell(x,y-1), new Cell(x+1,y-1),
                new Cell(x-1,y), new Cell(x+1,y),
                new Cell(x-1,y+1), new Cell(x,y+1), new Cell(x+1,y+1)});
    }

}
