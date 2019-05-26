import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {


    @Test
    public void gutterGame() {
        Game game = new Game();
        rollMany(0, 2, game);
        assertEquals(0, game.score());
    }

    @Test
    public void rollAllOnes() {
        Game game = new Game();

        rollMany(1, 2, game);
        assertEquals(2, game.score());
    }

    @Test
    public void rollSingleSpare() {
        Game game = new Game();

        game.roll(5);
        game.roll(5);
        game.roll(3);

        assertEquals(16, game.score());
    }

    @Test
    public void rollAllStrike() {
        Game game = new Game();
        rollMany(10, 21, game);
        assertEquals(300, game.score());
    }


    private void rollMany(int points, int count, Game game) {
        for(int i = 0; i < count; i++) {
            game.roll(points);
        }
    }
}
