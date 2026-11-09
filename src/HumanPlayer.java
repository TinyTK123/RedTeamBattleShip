public class HumanPlayer extends Player{
    public HumanPlayer(String name, ShipFactory shipFactory){
        super(name, shipFactory);
    }

    @Override
    public Coordinate takeShot(){
        // get input from player to create Coordinate
        // show grids for player
        System.out.println(getTargetGrid().display());
        System.out.println(getOceanGrid().display());

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
            if (getTargetGrid().isValidShot(shot)) {
                return shot;
            } else {
                System.out.println("You've already fired at that coordinate.");
                continue;
            }
        }
    }
}