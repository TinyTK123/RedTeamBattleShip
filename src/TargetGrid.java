/**
 * The player's view of the opponent's ocean.
 * Tracks where shots have been fired and whether each was a HIT or a MISS.
 * Ships are never placed here; cells only move from Empty to HIT or MISS.
 */
public class TargetGrid extends Grid {

    public TargetGrid() {
        super();
    }

    /**
     * Checks whether a shot at the given coordinate is allowed.
     * A shot is valid if the coordinate is inside the grid bounds
     * and that cell has not already been fired upon (not HIT or MISS).
     *
     * @param shot the target coordinate
     * @return true if the shot can be fired, false otherwise
     */
    public boolean isValidShot(Coordinate shot) {
        Cell cell = this.getCellAtCoord(shot);
        CellState cellState = cell.getCellstate();

        if (cellState == CellState.HIT || cellState == CellState.MISS) {
        // This means the player has already fired at this cell
            return false;
        } else if (cellState == CellState.EMPTY) {
        // This means the player has yet to fire at this cell.
            return true;
        } else {
            return false;
        }
    }

    /**
     * Records the outcome of a shot fired at the opponent.
     * The result comes back from the opponent's OceanGrid.receiveShot().
     *
     * @param shot  the coordinate that was fired at
     * @param result the outcome, expected to be CellState.HIT or CellState.MISS
     * @return a string that reveals the outcome of the shot.
     */
    public String receiveShotResult(ShotResult shotResult) {
        // ShotResult contains the coordinate, shotOutcome, and shipName
        // shipName will only be used if the shotOutcome is SUNK.
        
        Coordinate shot = shotResult.getShot();
        ShotOutcome shotOutcome = shotResult.getOutcome();
        String shipName = shotResult.getShipName();

        Cell cell = this.getCellAtCoord(shot);
        if (shotOutcome == ShotOutcome.HIT) {
            cell.setCellstate(CellState.HIT);
            return String.format("Miss recorded at %s.", shot);
        } else if (shotOutcome == ShotOutcome.MISS) {
            cell.setCellstate(CellState.MISS);
            return String.format("Successful hit recorded at %s.", shot);
        } else {
            cell.setCellstate(CellState.HIT);
            return String.format("You just sank your opponent's %s!", shipName);
        }
    }
}