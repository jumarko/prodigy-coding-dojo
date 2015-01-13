import static java.util.Collections.singletonMap;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Sort with fun!
 */
public class FunSort {

    public static <A,B extends Comparable<B>> List<A> funSort(List<A> input, final Function<A,B> fun) {
        return input.stream()
                .map((x) -> singletonMap(x, fun.apply(x)))
                .sorted((p1, p2) -> firstValue(p1).compareTo(firstValue(p2)))
                .map(FunSort::firstKey)
                .collect(toList());
    }

    private static <A, B extends Comparable<B>> A firstKey(Map<A, B> p) {
        return p.keySet().iterator().next();
    }

    private static <A, B extends Comparable<B>> B firstValue(Map<A, B> p1) {
        return p1.values().iterator().next();
    }
}
