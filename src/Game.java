public class Game {
    MainMenu menu = new MainMenu();
    TargetGrid tg = new TargetGrid();
    OceanGrid og = new OceanGrid();
    private Player player1;
    private Player player2;
    
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(){

        menu.display();

    }

    public void clearScreen(){
        while (true){
            ConsoleHelper.getInput("Press Enter To clear the screen");
            System.out.print("\033[2J");
        }
    }
}
