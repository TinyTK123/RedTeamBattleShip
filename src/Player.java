import java.util.List;

public abstract class Player {
    private String name;
    private List<Ship> ships;
    private TargetGrid targetGrid;
    private OceanGird oceanGird;
    
    public Player(String name) {
        this.name = name;
    }

    public Coordinate takeShot(){

    }

    public ShotResult receiveShot(Coordinate shot){

    }

    public void receiveShotResult(){

    }
}
