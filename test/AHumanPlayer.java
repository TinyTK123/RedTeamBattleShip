import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AHumanPlayer {
    @Test 
    void shouldBeAbleToGetName() {
        Player hp = new HumanPlayer("John");
        String name = hp.getName();
        assertEquals("John", name);
    }
}
