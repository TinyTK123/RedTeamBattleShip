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
            Coordinate coordOne = new Coordinate("E5");
            g.receiveShot(coordOne);
        } catch (Exception e) {
            // Ignore no exeptions
        }
        IO.println(g.display() + ConsoleColors.RESET);

        try {
            Coordinate coordTwo = new Coordinate("F5");
            g.receiveShot(coordTwo);
        } catch (Exception e) {
            // Ignore no exeptions
        }
        IO.println(g.display() + ConsoleColors.RESET);


        ConsoleHelper.getInput("Press Enter to return to Main Menu");
        ConsoleHelper.getInput(" ");
    }
}
