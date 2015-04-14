import static java.util.Arrays.stream;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
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

        final String customDelimiter = getCustomDelimiter(numbers);
        final String toSum = getNumbersToSum(numbers, customDelimiter);

        if (isEmpty(toSum)) {
            return 0;
        }

        // must use -1 as limit to not allow trailing separators
        return stream(toSum.split(delimiterRegex(",", "\n", customDelimiter), -1))
                .map(s -> {
                    final String trimmed = s.trim();
                    if (Integer.valueOf(trimmed) < 0) {
                        throw new StringCalculatorException("negative numbers not supported: " + trimmed);
                    }
                    return trimmed;
                })
                .collect(Collector.of(
                        () -> new AtomicInteger(0),
                        (AtomicInteger a, String b) -> a.set(a.addAndGet(Integer.valueOf(b))),
                        (a, b) -> new AtomicInteger(a.get() + b.get()),
                        a -> a.get()));
//                .collect(Collectors.summingInt(Integer::valueOf));
    }

    private String getNumbersToSum(String numbers, String customDelimiter) {
        String toSum = numbers;
        if (customDelimiter != null) {
            toSum = numbers.substring(numbers.indexOf('\n') + 1);
        }
        return toSum;
    }

    private String getCustomDelimiter(String numbers) {
        if (numbers.startsWith("//")) {
            final int firstNewLine = numbers.indexOf('\n');
            return numbers.substring(2, firstNewLine);
        }
        return null;
    }

    private String delimiterRegex(String... delimiters) {
        return Arrays.stream(delimiters).filter(s -> s != null && !s.isEmpty()).collect(Collectors.joining("|"));
    }



    private boolean isEmpty(String numbers) {
        return numbers == null || numbers.trim().length() == 0;
    }
}
