import java.util.List;

public class Tutorial {
    
    // static for now will be changed later
    public static void displayTutorial() {
        OceanGrid g = new OceanGrid();
        IO.println(g.display() + ConsoleColors.RESET);
        
        Ship ship = new Ship("carrier" , 5);
        try {
        ship.setCoordinates(List.of(new Coordinate("e3"), new Coordinate("e4"), new Coordinate("e5"), new Coordinate("e6"), new Coordinate("e7")));
        g.placeShips(List.of(ship));
        } catch (Exception e) {
            // Ignore no exeptions
        }
        IO.println(g.display() + ConsoleColors.RESET);

        try {
            Coordinate coord = new Coordinate("E5");
            g.receiveShot(coord);
        } catch (Exception e) {
            // Ignore no exeptions
        }
        IO.println(g.display() + ConsoleColors.RESET);

        try {
            Coordinate coord = new Coordinate("F5");
            g.receiveShot(coord);
        } catch (Exception e) {
            // Ignore no exeptions
        }
        IO.println(g.display() + ConsoleColors.RESET);


        ConsoleHelper.getInput("Press Enter to return to Main Menu");
        ConsoleHelper.getInput(" ");
    }
}
