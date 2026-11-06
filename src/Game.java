public class Game {
    MainMenu menu = new MainMenu();
    TargetGrid tg = new TargetGrid();
    OceanGrid og = new OceanGrid();
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void displayCurrentPlayer() {
        System.out.println("Current player: " + currentPlayer.getName());
    }

    void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public void play() {
        try {
            player1.getName();
            player2.getName();
        } catch (UnsupportedOperationException e) {
            System.out.println("Player names are not implemented yet.");
        }
        try {
            player1.takeShot();
            player2.takeShot();
        } catch (UnsupportedOperationException e) {
            System.out.println("Player shot methods are not implemented yet.");
        }
        try {
            player1.turn();
            player2.turn();
        } catch (UnsupportedOperationException e) {
            System.out.println("Player turn methods are not implemented yet.");
        }

        menu.display();

    }

    public void clearScreen() {
        while (true) {
            ConsoleHelper.getInput("Press Enter To clear the screen");
            System.out.print("\033[2J");
        }
    }
}
