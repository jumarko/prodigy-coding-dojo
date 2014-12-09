import static junit.framework.Assert.assertEquals;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    @Test
    public void gutterGame() {
        rollMany(20, 0);

        assertEquals(0, game.score());
    }

    @Test
    public void normalGame() {
        rollMany(20, 1);

        assertEquals(20, game.score());
    }

    @Test
    public void oneSpareGame() {
        rollMany(2, 5);
        rollMany(18,1);

        assertEquals(29, game.score());
    }

    @Test
    public void oneStrikeGame() {
        rollMany(1, 10);
        rollMany(18, 1);

        assertEquals(30, game.score());
    }

    @Test
    public void twoStrikesGame() {
        rollMany(2, 10);
        rollMany(16, 1);

        assertEquals(49, game.score());
    }
}
