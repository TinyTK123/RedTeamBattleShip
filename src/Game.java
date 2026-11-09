import java.util.ArrayList;
import java.util.List;

public class Game {
    MainMenu menu = new MainMenu();
    TargetGrid tg = new TargetGrid();
    OceanGrid og = new OceanGrid();
    private Player player1;
    private Player player2;

    private List<Player> players = new ArrayList<Player>();
    private int currentPlayerIndex = 0;

    public void addPlayer(Player player) {
        players.add(player);
    }

    // swap turns
    /*
     * public Game(Player player1, Player player2) {
     * this.player1 = player1;
     * this.player2 = player2;
     * this.currentPlayer = player1;
     * }
     */
    void switchCurrentPlayer() {
        if (currentPlayerIndex == 0) {
            currentPlayerIndex = 1;
        } else {
            currentPlayerIndex = 0;
        }

    public void displayCurrentPlayer() {
        System.out.println("Current player: " + players.get(currentPlayerIndex).getName());
    }


    }

    public void play() {
        menu.display();

    }

    public void clearScreen() {
        while (true) {
            ConsoleHelper.getInput("Press Enter To clear the screen");
            System.out.print("\033[2J");
        }
    }
}
