public final class Wrapper {

    private Wrapper() {}

    public static String wrap(String toWrap, int columnLength) {
        if (toWrap.length() <= columnLength ) {
            return toWrap;
        }

        final String head = getHead(toWrap, columnLength);
        final String tail = getTail(toWrap, head);
        return head + '\n' + wrap(tail, columnLength);

    }

    private static String getHead(String toWrap, int columnLength) {
        String head = toWrap.substring(0, columnLength);

        final int lastSpaceIndex = head.lastIndexOf(' ');

        if (lastSpaceIndex != -1) {
            head = head.substring(0, lastSpaceIndex);
        }
        return head;
    }

    private static String getTail(String toWrap, String head) {
        String tail = toWrap.substring(head.length());
        if (tail.startsWith(" ")) {
            tail = tail.substring(1);
        }
        return tail;
    }


    //--------------------------------------------------- OLD solution -------------------------------------------------

    // Following solution is both too complex and incorrect (doesn't run all the tests)
    // It's left hear as a demonstration of "dead end"
    public static String wrapOld(String toWrap, int columnLength) {
        if (toWrap.length() <= columnLength ) {
            return toWrap;
        }

        final StringBuilder parts = new StringBuilder();
        final int partsCount = toWrap.length() / columnLength;
        for (int i = 0; i < partsCount; i++) {
            parts.append(toWrap.substring(i * columnLength, (i + 1) * columnLength).trim());
            parts.append('\n');
        }
        parts.append(toWrap.substring((partsCount) * columnLength).trim());
        if (parts.charAt(parts.length() - 1) == '\n') {
            parts.deleteCharAt(parts.length() - 1);
        }
        return parts.toString();
    }

}
