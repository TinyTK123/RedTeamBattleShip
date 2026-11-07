public class GameConfig {
    private Player player1 = null;
    private Player player2 = null;
    private int NumberOfPlayers;

    // get the number of players to determine if you only need 1 instance, or 2, of the Human Player. 
    private int getNumberOfPlayers(){
        return NumberOfPlayers = ConsoleHelper.getNumberBetween("How would you like to play? \n 1. Single Player (vs AI) 2. Two Player \n", 1, 2);
    } 

    private String getPlayerName(int NumberOfPlayers){
        if (NumberOfPlayers == 1){
            String input = ConsoleHelper.getInput("Player 1, What is yout name?");
        } else {
            String input = ConsoleHelper.getInput("Player 1, What is yout name?");
            String input1 = ConsoleHelper.getInput("Player 2, What is yout name?");
        }
    }

    private Player createHumanPlayers(/* name, ship factory */){

    } 



    public void selectGameMode() {
        // only applies to single player
        while (true) {
            String selectGameMode = ConsoleHelper.getInput("Select Difficulty: \n 1. Easy  2. Medium  3. Hard \n");
            if (selectGameMode.equals("1")){
                IO.println("Easy AI selected.");
            }
            if (selectGameMode.equals("2")){
                IO.println("Medium AI selected.");
            }
            if (selectGameMode.equals("3")){
                IO.println("Hard AI selected.");
            }
        break;
        }
    }

    public void gameConfigSettings(){
        while (true){
            IO.println("You have chosen the following settings: (Game Settings Will Go Here)" );
            String confirmSettings = ConsoleHelper.getInput("Confirm Settings: \n 1. Yes  2. No \n");
            if (confirmSettings.equals("1")){
                IO.println("Great! Preparing Game . . .");
                break;
            }
            if (confirmSettings.equals("2")){
                setUp();
                break;
            }
        break;
        }
    }
}
