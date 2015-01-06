import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Sort with fun!
 */
public class FunSort {

    public static <A,B extends Comparable<B>> List<A> funSort(List<A> input, final Function<A,B> fun) {


        final Comparator<A> inputComparator = new Comparator<A>() {
            private Map<A,B> cache = new HashMap<>();

            @Override
            public int compare(A o1, A o2) {

                return getFromCache(o1).compareTo(getFromCache(o2));
            }

            B getFromCache(A key) {
                B b = cache.get(key);
                if (b == null) {
                    b = fun.apply(key);
                    cache.put(key, b);
                }
                return b;
            }
        };
        List<A> sortedInput = new ArrayList<>(input);
        sortedInput.sort(inputComparator);

        return sortedInput;
    }

}
