import java.util.List;

public abstract class Player {
    private String name;
    private List<Ship> ships;
    private TargetGrid targetGrid = new TargetGrid();
    private OceanGrid oceanGrid = new OceanGrid();
    private ShipFactory shipFactory;
    
    public Player(String name, ShipFactory shipFactory) {
        this.name = name;
        this.shipFactory = shipFactory;
    }

    public String getName() {
        return name;
    }

    public abstract Coordinate takeShot();

    // public ShotResult receiveShot(Coordinate shot){

    // }

    public List<Ship> placeShips() {
        return shipFactory.getShips();
    }

    // Update player's target grid to reflect the outcome of the shot they fired. Returns the outcome
    // of the shot, which can be used to display a textual message in the console reflecting the outcome
    // of the shot. This would likely happen in the play() method of class Game.
    public ShotOutcome receiveShotResult(ShotResult result) {	
		ShotOutcome outcome = result.getOutcome();
		Coordinate shot = result.getShot();
		Cell cell = targetGrid.getCellAtCoord(shot);

		if (outcome == ShotOutcome.MISS) {
			cell.setCellstate(CellState.MISS);
		} else {
			cell.setCellstate(CellState.HIT);
		}

		return outcome;
	}

    // The player receives a shot, and the shot is compared against the player's ocean grid.
    // The cellState of the targeted cell is updated depending on the outcome of the shot,
    // and the method returns a shotResult built to fit the outcome of the shot.
    public ShotResult receiveShot(Coordinate shot) {
        Cell targetedCell = oceanGrid.getCellAtCoord(shot);
        CellState targetedCellState = targetedCell.getCellstate();
        ShotResult result;
        if (targetedCellState == CellState.EMPTY) {
            targetedCell.setCellstate(CellState.MISS);
            result = new ShotResult(ShotOutcome.MISS, shot);
        } else if (targetedCellState == CellState.OCCUPIED) {
            targetedCell.setCellstate(CellState.HIT);
            result = new ShotResult(ShotOutcome.HIT, shot);
        }
        // The block only executes when the CellState is HIT or MISS
        // This means that the cell has already been fired upon
        // In theory, this should never execute, as the opposing player's targetGrid.isValidShot should prevent this.
        //TODO: ShotOutcome may need to be updated with a new value, INVALID, just in case.
        // A similar case can be found on OceanGrid.java line 40.
        else {
            targetedCell.setCellstate(CellState.MISS);
            result = new ShotResult(ShotOutcome.MISS, shot);
        }
        return result;
    }

    // TODO: player subclasses require these protected getters to access the targetGrid and oceanGrid.
    // This works for now, but it may be in our best interest to rework the Player base class into
    // an interface sometime in the future.
    protected TargetGrid getTargetGrid() {
        return targetGrid;
    }

    protected OceanGrid getOceanGrid() {
        return oceanGrid;
    }
}
