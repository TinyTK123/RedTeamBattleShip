public class MainMenu{

    private GameConfig gf = new GameConfig();

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
        while(true){
            String chooseMenuOption = ConsoleHelper.getInput("Choose what you would like to do: \n 1. Play Game 2. Tutorial 3. Quit \n");

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
        gf.setUp();
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