import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class AGrid {
    Grid g;

    @BeforeEach 
    void setup() {
        g = new Grid();
    }

    @Test
    void shouldBeAbleToDisplayEmpty() {
        System.out.println(g.display());
    }

    @Test 
    void shouldBeAbleToDisplayShips() throws Exception {
        Cell cell = g.getCellAtCoord(new Coordinate("E4"));
        cell.setCellstate(CellState.OCCUPIED);
        System.out.println(g.display());
    }

    @Test 
    void shouldBeAbleToDisplayHits() throws Exception {
        Cell cell = g.getCellAtCoord(new Coordinate("J8"));
        cell.setCellstate(CellState.HIT);
        System.out.println(g.display());
    }

    @Test 
    void shouldBeAbleToDisplayMisses() throws Exception {
        Cell cell = g.getCellAtCoord(new Coordinate("A10"));
        cell.setCellstate(CellState.MISS);
        System.out.println(g.display());
    }
}
