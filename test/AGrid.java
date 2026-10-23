import org.junit.jupiter.api.Test;

public class AGrid {
    @Test
    void shouldBeAbleToDisplayEmpty() {
        Grid grid = new Grid();
        System.out.println(grid.display());
    }
}
