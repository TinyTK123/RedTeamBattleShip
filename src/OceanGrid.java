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
            int shipDamage = ship.getHits().size();
            if (shipDamage == ship.getLength()) {
                ShotResult shotResult = new ShotResult(ShotOutcome.SUNK, shotCoordinate);
                shotResult.setShipName(ship.getName());
                cell.setCellstate(CellState.HIT);
                return shotResult;
            } else {
                ShotResult shotResult = new ShotResult(ShotOutcome.HIT, shotCoordinate);
                shotResult.setShipName(ship.getName());
                cell.setCellstate(CellState.HIT);
                return shotResult;
            }

        } else if (cell.getCellstate() == CellState.EMPTY) {
            // Miss
            ShotResult shotResult = new ShotResult(ShotOutcome.MISS, shotCoordinate);
            cell.setCellstate(CellState.MISS);
            return shotResult;
        } else {
            // The block only executes when the CellState is HIT or MISS
            // This means that the cell has already been fired upon
            // In theory, this should never execute, as the opposing player's targetGrid.isValidShot should prevent this.
            //TODO: ShotOutcome may need to be updated with a new value, INVALID, just in case.
            ShotResult shotResult = new ShotResult(ShotOutcome.MISS, shotCoordinate);
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
}