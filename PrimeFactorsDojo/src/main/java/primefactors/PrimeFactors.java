package primefactors;

import java.util.LinkedList;
import java.util.List;

public class PrimeFactors {


    public static List<Integer> generate(int number) {
        final LinkedList<Integer> primeFactors = new LinkedList<Integer>();

        int factor = 2;
        while (number > 1 && factor <= number) {
            if (number % factor == 0) {
                primeFactors.add(factor);
                number /= factor;
            } else {
                factor++;
            }
        }

        return primeFactors;
    }
}
