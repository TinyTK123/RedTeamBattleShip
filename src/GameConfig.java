public class GameConfig {
    private Player player1 = null;
    private Player player2 = null;
    private int numberOfPlayers;

    
    public Game configureAndCreateGame(){

    }

    // get the number of players to determine if you only need 1 instance, or 2, of the Human Player. 
    private int getNumberOfPlayers(){
        while(true){
            try{
                numberOfPlayers = ConsoleHelper.getNumberBetween("How would you like to play? \n 1. Single Player (Vs AI)\n 2. Two Player (Vs Human) \n", 1, 2);
                return numberOfPlayers;
            } catch (Exception e){
                IO.println("Please enter 1 or 2");
            }
        }
    } 

    private String getPlayerName(){
        return ConsoleHelper.getInput("Enter your name: ");
    }
    


    private ShipFactory getDesiredShipFactory() {
        while (true){
            try{
                int chooseSF = ConsoleHelper.getNumberBetween("How would you like to place your ships? \n 1. Manual \n 2. Automatic \n", 1, 2);

                if (chooseSF == 1){
                    return new ManualShipFactory();
                } else {
                    return new AutomaticShipFactory();
                }
            } catch (Exception e){
                IO.println("Please enter 1 or 2");
            }
        }
    }



    public void selectGameMode() {
/*  THIS MAY STILL BE USEFUL, Keeping for now (just in case)
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
*/
    }

    public void gameConfigSettings(){
/*  THIS NEEDS TO BE REFACTORED TO FIT UPDATED GAME CONFIG
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
*/
}
}
