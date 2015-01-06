import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunSortTest {

    public static Function<Integer, Integer> QUAD_FUN = (x) -> x*x;

    @Test
    public void testEmptyList() {
        final ArrayList<Integer> emptyList = new ArrayList<>();
        assertEquals(emptyList, FunSort.funSort(emptyList, QUAD_FUN));
    }

    @Test
    public void testOneElement() {
        assertEquals(singletonList(0), FunSort.funSort(singletonList(0), QUAD_FUN));
    }


    @Test
    public void testMultipleElements() {
        final List<Integer> input = asList(-1, 0, -2, 4);
        assertEquals(asList(0, -1, -2, 4), FunSort.funSort(input, QUAD_FUN));
    }

    @Test
    public void testMultipleElementsEfficiently() {
        final List<Integer> input = asList(-1, 0, -2, 4);
        final Function<Integer, Integer> funSpy = Mockito.spy(new QuadFun());

        assertEquals(asList(0, -1, -2, 4), FunSort.funSort(input, funSpy));
        verify(funSpy, times(4)).apply(anyInt());
    }


    static class QuadFun implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer val) {
            return val*val;
        }
    }
}