public class MainMenu{
    public void display(){
        IO.println("░████████                 ░██       ░██    ░██                       ░██        ░██           \r\n" + //
                    "░██    ░██                ░██       ░██    ░██                       ░██                      \r\n" + //
                    "░██    ░██   ░██████   ░████████ ░████████ ░██  ░███████   ░███████  ░████████  ░██░████████  \r\n" + //
                    "░████████         ░██     ░██       ░██    ░██ ░██    ░██ ░██        ░██    ░██ ░██░██    ░██ \r\n" + //
                    "░██     ░██  ░███████     ░██       ░██    ░██ ░█████████  ░███████  ░██    ░██ ░██░██    ░██ \r\n" + //
                    "░██     ░██ ░██   ░██     ░██       ░██    ░██ ░██               ░██ ░██    ░██ ░██░███   ░██ \r\n" + //
                    "░█████████   ░█████░██     ░████     ░████ ░██  ░███████   ░███████  ░██    ░██ ░██░██░█████  \r\n" + //
                    "                                                                                   ░██        \r\n" + //
                    "                                                                                   ░██        \r\n" + //
                    "                                                                                              ");
        String chooseMenuOption = ConsoleHelper.getInput("Choose what you would like to do: \n 1. Play Game 2. Tutorial 3. Quit");
        while(true){
            if(chooseMenuOption.equals("1")){
                playGame();
            }
            if(chooseMenuOption.equals("2")){
                tutorial();
            }
            if(chooseMenuOption.equals("3")){
                quitGame();
            }
        }
    }
    public void playGame(){
        IO.println(" This begings the Game Config? ");
    }

    public void tutorial(){
        IO.println("This will be the tutorial to the game");
        ConsoleHelper.getInput("Press Enter to return to Main Menu");
    }

    public void quitGame(){
        IO.println("This will close the game.");
    }
}