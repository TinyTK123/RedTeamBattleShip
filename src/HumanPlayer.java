import java.lang.annotation.Target;
import java.util.List;

public class HumanPlayer implements Player{

    private String name; 
    private ShipFactory shipFactory;
    private OceanGrid oceanGrid = new OceanGrid();
    private TargetGrid targetGrid = new TargetGrid();

    public HumanPlayer(String name, ShipFactory shipFactory){
        this.name = name;
        this.shipFactory = shipFactory;
    }

    @Override
    public Coordinate takeShot(){
        // get input from player to create Coordinate
        // show grids for player
        System.out.println(targetGrid.display());
        System.out.println(oceanGrid.display());

        while (true) {
            Coordinate shot;
            try {
                String playerInput = ConsoleHelper.getInput(ConsoleColors.RESET + "Input the coordinate you'd like to fire upon: ");
                shot = new Coordinate(playerInput);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            // check if shot was valid, if valid return, if not give message and continue
            if (targetGrid.isValidShot(shot)) {
                return shot;
            } else {
                System.out.println("You've already fired at that coordinate.");
                continue;
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ShotResult receiveShot(Coordinate c) {
        return oceanGrid.receiveShot(c);
    }

    @Override
    public void receiveShotResult(ShotResult result) {
        targetGrid.receiveShotResult(result);
    }

    @Override
    public boolean shipsAreSunk() {
        return oceanGrid.shipsAreSunk();
    }

    @Override
    public void placeShip() {
        List<Ship> ships = shipFactory.getShips();
        oceanGrid.placeShips(ships);
    }
}