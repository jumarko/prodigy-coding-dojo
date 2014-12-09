import java.util.Arrays;

public class Game {

    private int[] rolls = new int[21];
    private int position = 0;

    public void roll(int pins) {

        rolls[position] = pins;
        if (pins == 10 && position % 2 == 0) {
            position++;
        }

        position++;
    }

    public int score() {
        int score = 0;
        for (int frame = 0; frame < rolls.length / 2; frame++) {
            if (isStrike(frame)) {
                int rollOffset = isStrike(frame + 1) ? 2 : 1;
                score += rolls[(frame + 1) * 2];
                score += rolls[(frame + 1) * 2 + rollOffset];
            } else if (isSpare(frame)) {
                score += rolls[(frame + 1) * 2];
            }

            score += rolls[frame * 2];
            score += rolls[frame * 2 + 1];
        }

        return score;
    }

    private boolean isSpare(int frame) {
        final int frameScore = rolls[frame * 2] + rolls[frame * 2 + 1];

        return frameScore == 10;
    }

    private boolean isStrike(int frame) {
        return rolls[frame * 2] == 10;
    }
}
