/**
 * The player's view of the opponent's ocean.
 * Tracks where shots have been fired and whether each was a Hit or a Miss.
 * Ships are never placed here; cells only move from Empty to Hit or Miss.
 */
public class TargetGrid extends Grid {

    public TargetGrid() {
        super();
    }

    /**
     * Checks whether a shot at the given coordinate is allowed.
     * A shot is valid if the coordinate is inside the grid bounds
     * and that cell has not already been fired upon (not Hit or Miss).
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
     * @param coord  the coordinate that was fired at
     * @param result the outcome, expected to be CellState.HIT or CellState.MISS
     */
    public void receiveShot(Coordinate coord, CellState result) {
        // TODO: look up the cell via getCellAtCord(coord)
        // TODO: set the cell's state to the result
    }
}