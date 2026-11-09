import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

public class AnOceanGrid {

    OceanGrid og;

    @BeforeEach 
    void setup() {
        og = new OceanGrid();
    }

    @Test
    void shouldBeAbleToBeMAde(){
        assertNotNull(og);
        assertInstanceOf(OceanGrid.class, og);
    }

    @Test
    void shouldBeDisplayableEmpty(){
        // no assertion, will always pass
        // used to visulize gird
        System.out.println(og.display());
    }

    @Test
    void ShouldBeAbleToPlaceShips() {
        List<Ship> ships = this.collectionOfShips();

        og.placeShips(ships);
        
        System.out.println(og.display());
    }

    @Test
    void shouldBeAbleToSeeHitShip() {
        List<Ship> ships = this.collectionOfShips();
        og.placeShips(ships);
        try {
            og.receiveShot(new Coordinate("A3"));
        } catch (Exception e) {
            assertTrue(false);
        }

        System.out.println(og.display());
    }

    @Test
    void hittingAShipShouldResultInHITShotResult() {
        List<Ship> ships = this.collectionOfShips();
        og.placeShips(ships);
        try {
            ShotOutcome so = og.receiveShot(new Coordinate("A3")).getOutcome();
            assertEquals(ShotOutcome.HIT, so);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    List<Ship> collectionOfShips() {
        Ship ship1 = new Ship("Carrier", 5);
        Ship ship2 = new Ship("Battleship", 4);
        Ship ship3 = new Ship("Cruiser", 3);
        Ship ship4 = new Ship("Submarine", 3);
        Ship ship5 = new Ship("Destroyer", 2);
        List<Coordinate> coords1 = null;
        List<Coordinate> coords2 = null;
        List<Coordinate> coords3 = null;
        List<Coordinate> coords4 = null;
        List<Coordinate> coords5 = null;
        try {
            coords1 = List.of(new Coordinate("E5"), new Coordinate("F5"), new Coordinate("G5"), new Coordinate("H5"), new Coordinate("I5"));
            coords2 = List.of(new Coordinate("A1"), new Coordinate("A2"), new Coordinate("A3"), new Coordinate("A4"));
            coords3 = List.of(new Coordinate("C2"), new Coordinate("D2"), new Coordinate("E2"));
            coords4 = List.of(new Coordinate("F7"), new Coordinate("G7"), new Coordinate("H7"));
            coords5 = List.of(new Coordinate("J8"), new Coordinate("J9"));
        } catch (Exception e) {
            assertFalse(true);
        }
        ship1.setCoordinates(coords1);
        ship2.setCoordinates(coords2);
        ship3.setCoordinates(coords3);
        ship4.setCoordinates(coords4);
        ship5.setCoordinates(coords5);

        List<Ship> ships = List.of(ship1, ship2, ship3, ship4, ship5);
        return ships;
    }
}
