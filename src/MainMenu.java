public class MainMenu{

    public void display(){
        IO.println(ConsoleColors.CYAN + 
                    "░████████                 ░██       ░██    ░██                       ░██        ░██           \r\n" + //
                    "░██    ░██                ░██       ░██    ░██                       ░██                      \r\n" + //
                    "░██    ░██   ░██████   ░████████ ░████████ ░██  ░███████   ░███████  ░████████  ░██░████████  \r\n" + //
                    "░████████         ░██     ░██       ░██    ░██ ░██    ░██ ░██        ░██    ░██ ░██░██    ░██ \r\n" + //
                    "░██     ░██  ░███████     ░██       ░██    ░██ ░█████████  ░███████  ░██    ░██ ░██░██    ░██ \r\n" + //
                    "░██     ░██ ░██   ░██     ░██       ░██    ░██ ░██               ░██ ░██    ░██ ░██░███   ░██ \r\n" + //
                    "░█████████   ░█████░██     ░████     ░████ ░██  ░███████   ░███████  ░██    ░██ ░██░██░█████  \r\n" + //
                    "                                                                                   ░██        \r\n" + //
                    "                                                                                   ░██        \r\n" + //
                    "                                                                                              " + ConsoleColors.RESET);
        while(true){
            String chooseMenuOption = ConsoleHelper.getInput("Choose what you would like to do: \n 1. Play Game \n 2. Tutorial \n 3. Quit \n");

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
        GameConfig gf = new GameConfig();
        gf.configureAndCreateGame();
        ConsoleHelper.getInput(" ");
    }

    public void tutorial(){
        IO.println("This will be the tutorial to the game");
        ConsoleHelper.getInput("Press Enter to return to Main Menu");
        ConsoleHelper.getInput(" ");
    }

    public void quitGame(){
        IO.println("Thanks for playing!");
        System.exit(0);
    }
}