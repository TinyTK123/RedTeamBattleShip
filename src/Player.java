import java.util.List;

public abstract class Player {
    private String name;
    private ShipFactory shipFactory;
    private List<Ship> ships;
    private TargetGrid targetGrid;
    private OceanGrid oceanGrid;
    
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

    public void receiveShotResult(){

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
