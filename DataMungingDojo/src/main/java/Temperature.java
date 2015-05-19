import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Temperature {
    private List<TRecord> records;

    public Temperature(String dataFile) {
        try {
            records = Files.readAllLines(Paths.get("src/main/resources/" + dataFile)).stream()
                    .skip(2)
                    .filter(line -> line.trim().matches("^[0-9]+\\s+.*"))
                    .map(TRecord::new).collect
                    (toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("Bad input data file", e);
        }
    }

    public int smallestSpreadDay() {
        return records.stream().sorted(this::compareSpreads).findFirst().get().getDay();
    }

    private int compareSpreads(TRecord r1, TRecord r2) {
        return Double.compare(r1.getMaxTemp() - r1.getMinTemp(), r2.getMaxTemp() - r2.getMinTemp());

    }
}
