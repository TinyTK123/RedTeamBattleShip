import java.util.List;

public abstract class Player {
    private String name;
    private List<Ship> ships;
    private TargetGrid targetGrid;
    private OceanGrid oceanGrid;
    
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
/* 
    public Coordinate takeShot(){

    }

    public ShotResult receiveShot(Coordinate shot){

    }
*/
    public void receiveShotResult(){

    }
}
