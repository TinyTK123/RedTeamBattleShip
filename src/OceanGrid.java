import java.util.ArrayList;
import java.util.List;

public class OceanGrid extends Grid {
    private List<Ship> ships = new ArrayList<>();
    
    public OceanGrid() {
        super();
    }

    public ShotResult receiveShot(Coordinate shotCoordinate) {
        Cell cell = getCellAtCoord(shotCoordinate);
        if (cell.getCellstate() == CellState.OCCUPIED) {
            // Hit or Sunk
            Ship ship = cell.getShip();

            // check if shot resulted in a sunk
            ship.registerHit(shotCoordinate);
            int shipDamage = ship.getHits().size();
            if (shipDamage == ship.getLength()) {
                // Sunk
                ShotResult shotResult = ShotResult.sunk(shotCoordinate, ship.getName());
                cell.setCellstate(CellState.HIT);
                return shotResult;
            } else {
                // Hit
                ShotResult shotResult = ShotResult.hit(shotCoordinate);
                cell.setCellstate(CellState.HIT);
                return shotResult;
            }

        } else {
            // Miss
            ShotResult shotResult = ShotResult.miss(shotCoordinate);
            cell.setCellstate(CellState.MISS);
            return shotResult;
        }
    }

    public void placeShips(List<Ship> ships) {
        for (Ship ship:ships) {
            this.ships.add(ship);
            List<Coordinate> coordinates = ship.getCoords();
            for (Coordinate coord:coordinates) {
                Cell cell = this.getCellAtCoord(coord);
                cell.setCellstate(CellState.OCCUPIED);
                cell.setShip(ship);
            }
        }
    }

    public boolean shipsAreSunk() {
        for (Ship ship:ships) {
            if (!ship.isSunk()){
                return false;
            }
        } 
        return true;
    }
}