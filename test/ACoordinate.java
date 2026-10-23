import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ACoordinate {
    @Test 
    void shouldBeAbleToBeMadeAtA1() throws Exception {
        Coordinate c = new Coordinate("a1");
        int row = c.getRow();
        int column = c.getColumn();
        assertEquals(0, row);
        assertEquals(0, column);
    }

    @Test
    void shouldBeAbleToBeMadeAtB2() throws Exception {
        Coordinate c = new Coordinate("b2");
        int row = c.getRow();
        int column = c.getColumn();
        assertEquals(1, row);
        assertEquals(1, column);
    }

    @Test
    void shouldBeAbleToBeMadeAtF8() throws Exception {
        Coordinate c = new Coordinate("f8");
        int row = c.getRow();
        int column = c.getColumn();
        assertEquals(5, row);
        assertEquals(7, column);
    }

    @Test
    void shouldBeAbleToBeMadeWithCapitalLetters() throws Exception {
        Coordinate c = new Coordinate("B2");
        int row = c.getRow();
        int column = c.getColumn();
        assertEquals(1, row);
        assertEquals(1, column);
    }

    @SuppressWarnings("unused")
    @Test 
    void shouldNotBeAbleToBeCreatedWithABadRow() {
        assertThrows(Exception.class, () -> {
            Coordinate c = new Coordinate("X7");
        });
    }

    @SuppressWarnings("unused")
    @Test 
    void shouldNotBeAbleToBeCreatedWithABadColumn() {
        assertThrows(Exception.class, () -> {
            Coordinate c = new Coordinate("C77");
        });
    }

    @SuppressWarnings("unused")
    @Test 
    void shouldNotBeAbleToBeCreatedWithBadEverything() {
        assertThrows(Exception.class, () -> {
            Coordinate c = new Coordinate("Ted");
        });
    }

    @SuppressWarnings("unused")
    @Test 
    void shouldNotBeAbleToBeCreatedWithBadMistype() {
        assertThrows(Exception.class, () -> {
            Coordinate c = new Coordinate("CC4");
        });
    }

    @Test 
    void makeSureA4IsA4() throws Exception {
        Coordinate c = new Coordinate("A4");
        System.out.println(c);
    }

    @Test
    void isNotEqualToADifferentInstance() throws Exception {
        Coordinate c1 = new Coordinate("b7");
        Coordinate c2 = new Coordinate("b7");
        assertFalse(c1 == c2);
    }
    
    @Test
    void isEqualUsingEqualsAtSameRowColumn() throws Exception {
        Coordinate c1 = new Coordinate("b7");
        Coordinate c2 = new Coordinate("b7");
        assertTrue(c1.equals(c2));
    }

    @Test
    void hasSameCoordsGivesSameHashCode() throws Exception {
        Coordinate c1 = new Coordinate("b7");
        Coordinate c2 = new Coordinate("b7");
        assertTrue(c1.hashCode() == c2.hashCode());
    }

    @Test
    void generatesFourCoordinatesToSouth() throws Exception {
        Coordinate testStart = new Coordinate(2, 3);
        List<Coordinate> result = testStart.coordsInDirection(4, Direction.SOUTH);
        assertEquals(4, result.size());
        assertTrue(result.contains(new Coordinate(2, 3)));
        assertTrue(result.contains(new Coordinate(3, 3)));
        assertTrue(result.contains(new Coordinate(4, 3)));
        assertTrue(result.contains(new Coordinate(5, 3)));
    }

    @Test
    void generatesThreeCoordinatesToWest() throws Exception {
        Coordinate testStart = new Coordinate(2, 3);
        List<Coordinate> result = testStart.coordsInDirection(3, Direction.WEST);
        assertEquals(3, result.size());
        assertTrue(result.contains(new Coordinate(2, 3)));
        assertTrue(result.contains(new Coordinate(2, 2)));
        assertTrue(result.contains(new Coordinate(2, 1)));
    }

    @Test
    void generatesTwoCoordinatesToNorth() throws Exception {
        Coordinate testStart = new Coordinate(2, 3);
        List<Coordinate> result = testStart.coordsInDirection(2, Direction.NORTH);
        assertEquals(2, result.size());
        assertTrue(result.contains(new Coordinate(2, 3)));
        assertTrue(result.contains(new Coordinate(1, 3)));
    }

    @Test
    void generatesFiveCoordinatesToEast() throws Exception {
        Coordinate testStart = new Coordinate(2, 3);
        List<Coordinate> result = testStart.coordsInDirection(5, Direction.EAST);
        assertEquals(5, result.size());
        assertTrue(result.contains(new Coordinate(2, 3)));
        assertTrue(result.contains(new Coordinate(2, 4)));
        assertTrue(result.contains(new Coordinate(2, 5)));
        assertTrue(result.contains(new Coordinate(2, 6)));
        assertTrue(result.contains(new Coordinate(2, 7)));
    }

    @SuppressWarnings ("unused")
    @Test
    void canBeMadeWithRowCol() throws Exception {
        Coordinate c = new Coordinate(3, 2);
        assertEquals("D3", c.toString());
    }

    @SuppressWarnings ("unused")
    @Test
    void cannotBeMadeWithBadRowCol() {
        assertThrows(Exception.class, () -> {
            Coordinate c = new Coordinate(11, 11);
        });
    }

    @Test
    void canBeFoundInList() throws Exception {
        List<Coordinate> myList = List.of(new Coordinate("A5"));
        Coordinate c = new Coordinate("A5");
        assertTrue(myList.contains(c));
    }
}