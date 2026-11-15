
import java.util.List;

public class Tutorial {

    // Waits for Enter before moving to the next "slide"
    private static void pause() {
        ConsoleHelper.getInput("\n[Press Enter to continue]");
    }

    // static for now, will be changed later
    public static void displayTutorial() {
        OceanGrid g = new OceanGrid();

        // --- Slide 1: The grid ---
        IO.println("Welcome aboard, Admiral. This is your ocean grid.");
        IO.println("It's 10x10, with rows lettered A through J and columns numbered 1 through 10.");
        IO.println("Whenever the game asks you for a target, you'll answer with a coordinate like B7 or J10.");
        IO.println(g.display() + ConsoleColors.RESET);
        pause();

        // --- Slide 2: Placing a ship ---
        Ship ship = new Ship("carrier", 5);
        try {
            ship.setCoordinates(List.of(
                    new Coordinate("e3"), new Coordinate("e4"), new Coordinate("e5"),
                    new Coordinate("e6"), new Coordinate("e7")));
            g.placeShips(List.of(ship));
        } catch (Exception e) {
            IO.println("Something went wrong while placing the ship.");
        }
        IO.println("Here's a ship on the water. Ships show up as the letter 'S'.");
        IO.println("Check row E: this one stretches from E3 to E7.");
        IO.println("That's your Carrier, the biggest ship in the fleet at 5 spaces long.");
        IO.println(g.display() + ConsoleColors.RESET);
        pause();

        // --- Slide 3: A hit ---
        try {
            g.receiveShot(new Coordinate("E5"));
        } catch (Exception e) {
            // Tutorial shot, safe to ignore
        }
        IO.println("Direct hit! Someone fired on E5 and struck the Carrier.");
        IO.println("Hits are marked with an 'X'.");
        IO.println(g.display() + ConsoleColors.RESET);
        pause();

        // --- Slide 4: A miss ---
        try {
            g.receiveShot(new Coordinate("F5"));
        } catch (Exception e) {
            // Tutorial shot, safe to ignore
        }
        IO.println("This shot landed on F5 and found nothing but water.");
        IO.println("Misses are marked with an 'O'.");
        IO.println(g.display() + ConsoleColors.RESET);
        pause();

        // --- Outro ---
        IO.println("That's all you need to know. Hunt down the enemy fleet before they find yours.");
        IO.println("Good luck, Admiral!");
        ConsoleHelper.getInput("\n[Press Enter to return to the Main Menu]");
    }
}
