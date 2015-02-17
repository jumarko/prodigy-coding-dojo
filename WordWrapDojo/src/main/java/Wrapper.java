public final class Wrapper {

    private Wrapper() {}

    public static String wrap(String toWrap, int columnLength) {
        if (toWrap.length() <= columnLength ) {
            return toWrap;
        }

        final StringBuilder parts = new StringBuilder();
        final int partsCount = toWrap.length() / columnLength;
        for (int i = 0; i < partsCount; i++) {
            parts.append(toWrap.substring(i * columnLength, (i + 1) * columnLength));
            parts.append('\n');
        }
        parts.append(toWrap.substring((partsCount) * columnLength));
        if (parts.charAt(parts.length() - 1) == '\n') {
            parts.deleteCharAt(parts.length() - 1);
        }
        return parts.toString();
    }

}
