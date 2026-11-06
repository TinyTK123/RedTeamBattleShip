public class HumanPlayer extends Player{
    public HumanPlayer(String name){
        super(name);
    }

    @Override
    public Coordinate takeShot(){
        // get input from player to create Coordinate
        while (true) {
            try {
                String playerInput = ConsoleHelper.getInput("Input the coordinate you'd like to fire upon: ");
                Coordinate shot = new Coordinate(playerInput);
                return shot;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }
}