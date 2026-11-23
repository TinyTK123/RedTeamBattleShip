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
                // This code starts the game up
                GameConfig gf = new GameConfig();
                Game game = gf.configureAndCreateGame();
                game.play();
            }
            if(chooseMenuOption.equals("2")){
                // This code displays the tutorial
                Tutorial.displayTutorial();
            }
            if(chooseMenuOption.equals("3")){
                // This quits the game
                IO.println("Thanks for playing!");
                System.exit(0);
            }
        }
    }
}