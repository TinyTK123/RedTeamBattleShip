import java.util.ArrayList;
import java.util.List;

public class OceanGrid extends Grid {
    private List<Ship> ships = new ArrayList<>();
    
    public OceanGrid() {
        super();
    }

    public void placeShips(List<Ship> ships) {
        for (Ship ship:ships) {
            this.ships.add(ship);
            List<Coordinate> coordinates = ship.getCoordinates();
            for (Coordinate coord:coordinates) {
                Cell cell = this.getCellAtCoord(coord);
                cell.setCellstate(CellState.OCCUPIED);
                cell.setShip(ship);
            }
        }
    }
}