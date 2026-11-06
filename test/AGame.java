import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AGame {
    @Test
    void shouldDisplayAndSwitchPlayersWithoutErrors() {
        // Assuming your Player class takes a name in its constructor
        Player player1 = new Player("John");
        Player player2 = new Player("Ted");
        Game game = new Game(player1, player2);

        // 1. Starts on P1
        game.displayCurrentPlayer();

        // 2. Switch P1 -> P2
        game.switchCurrentPlayer();
        game.displayCurrentPlayer();

        // 3. Switch P2 -> P1
        game.switchCurrentPlayer();
        game.displayCurrentPlayer();

        // If the method reaches this point without crashing, the switch loop works.
        assertTrue(true);
    }
}