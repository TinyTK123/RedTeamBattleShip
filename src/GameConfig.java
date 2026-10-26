public class GameConfig {


    public void setUp() {
        while(true){
            selectOneVsTwoPlayers();
            selectGameMode();
            gameConfigSettings();
        }
    }

    public void selectOneVsTwoPlayers() {
        while(true){
            String choosePlayers = ConsoleHelper.getInput("How would you like to play? \n 1. Single Player (vs AI) \n 2. Two Player \n");
            if (choosePlayers.equals("1")){
                IO.println("Single Player selected");
            }
            if (choosePlayers.equals("2")){
                IO.println("Two Player selected");
            }
        break;
        }
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
