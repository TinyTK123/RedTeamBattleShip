public class GameConfig {
    private Player player1 = null;
    private Player player2 = null;
    private int numberOfPlayers;

    public Game configureAndCreateGame() {
        numberOfPlayers = getNumberOfPlayers();
        player1 = createHumanPlayer();

        if (numberOfPlayers == 1) {
            IO.println("Single Player is not available yet.");
            ConsoleHelper.getInput("Press enter to return to main menu");
            return null;
        } else if (numberOfPlayers == 2){
            player2 = createHumanPlayer();
        }
        return new Game(player1, player2);
    }

    // get the number of players to determine if you only need 1 instance, or 2, of
    // the Human Player.
    private int getNumberOfPlayers() {
        while (true) {
            try {
                numberOfPlayers = ConsoleHelper.getNumberBetween(
                        "How would you like to play? \n 1. Single Player (Vs AI)\n 2. Two Player (Vs Human) \n", 1, 2);
                return numberOfPlayers;
            } catch (Exception e) {
                IO.println("Please enter 1 or 2");
            }
        }
    }

    private String getPlayerName() {
        return ConsoleHelper.getInput("Enter your name: ");
    }

    private ShipFactory getDesiredShipFactory() {
        while (true) {
            try {
                int chooseSF = ConsoleHelper.getNumberBetween(
                        "How would you like to place your ships? \n 1. Manual \n 2. Automatic \n", 1, 2);

                if (chooseSF == 1) {
                    return new ManualShipFactory();
                } else {
                    return new AutomaticShipFactory();
                }
            } catch (Exception e) {
                IO.println("Please enter 1 or 2");
            }
        }
    }

    private Player createHumanPlayer() {
        String name = getPlayerName();
        ShipFactory shipFactory = getDesiredShipFactory();
        return new HumanPlayer(name, shipFactory);
    }

    public void selectGameMode() {
        // THIS MAY STILL BE USEFUL, Keeping for now (just in case)
        while (true) {
            try {
                int selectGameMode = ConsoleHelper
                        .getNumberBetween("Select Difficulty: \n 1. Easy \n  2. Medium \n  3. Hard \n", 1, 3);
                if (selectGameMode == 1) {
                    IO.println("Easy AI selected.");
                }
                if (selectGameMode == 2) {
                    IO.println("Medium AI selected.");
                }
                if (selectGameMode == 3) {
                    IO.println("Hard AI selected.");
                }
            } catch (Exception e) {
                IO.println("Please enter 1, 2, or 3");
            }
        }
    }
}
