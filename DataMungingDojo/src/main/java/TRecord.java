public class TRecord {
    private final int day;
    private final double maxTemp;
    private final double minTemp;
    public TRecord(String toParse) {
        if (toParse == null || toParse.length() == 0) {
            throw new IllegalArgumentException("Cannot pass empty string");
        }
        final String[] recordLine = toParse.trim().split("\\s+");

        if (recordLine.length < 3) {
            throw new IllegalArgumentException("Bad input record format: " + toParse);
        }

        day = Integer.valueOf(normalize(recordLine[0]));
        maxTemp = Double.valueOf(normalize(recordLine[1]));
        minTemp = Double.valueOf(normalize(recordLine[2]));
    }

    public int getDay() {
        return day;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    private String normalize(String s) {
        return s.replace("*", "");
    }
}
