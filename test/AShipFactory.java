import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class AShipFactory {

    ShipFactory factory;

    @BeforeEach
    void init(){
        factory = new AutomaticShipFactory();
    }

    @Test
    void producesFiveShips(){
        List<Ship> ships = factory.getShips();
        assertEquals(5, ships.size());
    }

    @Test
    void detectsOverlap() throws Exception {
        List<Coordinate> one = List.of(
            new Coordinate(2,3), // here's the overlap...
            new Coordinate(2,4),
            new Coordinate(2,5)
        );
        Set<Coordinate> two = Set.of(
            new Coordinate(1,3),
            new Coordinate(2,3), // here's the overlap...
            new Coordinate(3,3),
            new Coordinate(4,3)
        );
        assertTrue(factory.coordinatesOverlapExistingCoordinates(one, two));
    }

    @Test
    void detectsLackOfOverlap() throws Exception {
        List<Coordinate> one = List.of(
            new Coordinate(2,3),
            new Coordinate(2,4),
            new Coordinate(2,5)
        );
        Set<Coordinate> two = Set.of(
            new Coordinate(5,3),
            new Coordinate(5,4),
            new Coordinate(5,5),
            new Coordinate(5,6)
        );
        assertFalse(factory.coordinatesOverlapExistingCoordinates(one, two));
    }

    @Test
    void generatesShipsWithinBounds() {
        List<Ship> ships = factory.getShips();

        for (Ship ship : ships) {
            for (Coordinate coordinate : ship.getCoords()) {

                assertTrue(coordinate.getRow() >= 0);
                assertTrue(coordinate.getRow() <= 9);

                assertTrue(coordinate.getColumn() >= 0);
                assertTrue(coordinate.getColumn() <= 9);
            }
        }
    }

    // @Test
    // void display() {
    //     List<Ship> ships = factory.getShips();
    //     OceanGrid og = new OceanGrid(); 
    //     og.placeShips(ships);
    //     System.out.println(og.display());
    // }
}