// import java.util.ArrayList;
// import java.util.List;

public class Game {
    private Player player1;
    private Player player2;

    private Player currentPlayer;
    private Player otherPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.otherPlayer = player2;
    }

    private void switchCurrentPlayer() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
            otherPlayer = player1;
        } else {
            currentPlayer = player1;
            otherPlayer = player2;
        }
    }

    public void play() {
        player1.placeShips();
        player2.placeShips();
        while (true){
            System.out.println("Current player: " + currentPlayer.getName() + ", where would you like to shoot? ");

            // Player 1 sends shot 
            Coordinate shot = currentPlayer.takeShot(); 
            // Player 2 recieves shot 
            ShotResult sr = otherPlayer.receiveShot(shot);
            // recieve shot result 
            currentPlayer.receiveShotResult(sr);

            System.out.printf("%s shoots at %s", currentPlayer.getName(), shot.toString());
            // switch case works similar to if else statement.
            switch (sr.getOutcome()){
                case HIT -> System.out.printf(" . . . HIT! %n");
                case MISS -> System.out.printf(" . . . MISS! %n");
                case SUNK -> System.out.printf(" . . . HIT and SUNK! You sunk my %s%n", sr.getShipName().orElse("Undefined"));
            }
            
            // player is responsible for grids, not player
            if (otherPlayer.shipsAreSunk()){
                System.out.printf("Game Over! %s%n wins!", currentPlayer.getName());
                break;
            }

            switchCurrentPlayer();

            if (otherPlayer instanceof HumanPlayer){
                ConsoleHelper.getInput("\n Press enter to continue");
                ConsoleHelper.clearScreen();
                System.out.printf("%n Is %s ready?", currentPlayer.getName());
                ConsoleHelper.getInput("\n Press enter to continue");           
            }

        }

    }
}
