import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;

public class ATargetGrid {

    TargetGrid tg;

    @BeforeEach 
    void setup() {
        tg = new TargetGrid();
    }

    @Test 
    void shouldBeAbleToBeMade() {
        assertNotNull(tg);
        assertInstanceOf(TargetGrid.class, tg);
    }

    @Test 
    void shouldAllowShotOnEmptyCell() throws Exception {
        assertEquals(true, tg.isValidShot(new Coordinate("E4")));
    }

    @Test 
    void shouldRejectShotOnHitCell() throws Exception {
        Cell cell = tg.getCellAtCoord(new Coordinate("E4"));
        cell.setCellstate(CellState.HIT);
        assertEquals(false, tg.isValidShot(new Coordinate("E4")));
    }

    @Test 
    void shouldRejectShotOnMissedCell() throws Exception {
        Cell cell = tg.getCellAtCoord(new Coordinate("E4"));
        cell.setCellstate(CellState.MISS);
        assertEquals(false, tg.isValidShot(new Coordinate("E4")));
    }
}