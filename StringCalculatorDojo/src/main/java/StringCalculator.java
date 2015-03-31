import static java.util.Arrays.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    /**
     * Sums given numbers split by "," or "\n".
     *
     * @param numbers string containing number to be sum up
     * @return sum of numbers
     * @throws NumberFormatException in case of invalid number format or invalid separator (e.g. ",\n" is invalid sep.)
     */
    public int add(String numbers) {
        if (isEmpty(numbers)) {
            return 0;
        }

        // must use -1 as limit to not allow trailing separators
        return stream(numbers.split(",|\n", -1))
                .map(String::trim)
                .collect(Collectors.summingInt(Integer::valueOf));
    }



    private boolean isEmpty(String numbers) {
        return numbers == null || numbers.trim().length() == 0;
    }
}
