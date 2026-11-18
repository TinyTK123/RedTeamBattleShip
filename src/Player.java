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
