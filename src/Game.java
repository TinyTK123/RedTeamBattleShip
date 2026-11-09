import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player1;
    private Player player2;

    private Player currentPlayer = player1;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    private void switchCurrentPlayer() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public void displayCurrentPlayer() {
        System.out.println("Current player: " + currentPlayer.getName());
    }

    public void play() {
        player1.placeShips();
        clearScreen();
        player2.placeShips();
        clearScreen();
        player1.takeShot();
        player2.takeShot();
    }

    public void clearScreen() {
        while (true) {
            ConsoleHelper.getInput("Press Enter To clear the screen.");
            System.out.print("\033[2J");
            break;
        }
    }
}
