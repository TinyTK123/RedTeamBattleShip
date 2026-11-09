import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ManualShipFactory extends ShipFactory {
    private OceanGrid displayGrid = new OceanGrid();

    @Override
    protected Coordinate getStartCoordinate(Ship ship) {
        while (true) {
            Coordinate startCoordinate;
            try {
                System.out.println(String.format(ConsoleColors.RESET + "Currently placing: %s", ship.getName()));
                String playerInput = ConsoleHelper.getInput("Please select a starting coordinate.\n");
                startCoordinate = new Coordinate(playerInput);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            return startCoordinate;
        }
    }

    @Override
    protected Direction getStartDirection(Ship ship) {
        String prompt = String.format("Currently placing: %s\nSelect the corresponding number to choose a direction: \n1. North\n2. South\n3. East\n4. West\n", ship.getName());
        return Direction.equivalentTo(ConsoleHelper.getNumberBetween(prompt, 1, 4));
    }

    @Override
    protected void placementRejected(Ship ship, String reason) {
        System.out.println(reason);
    }

    @Override
    protected void placementAccepted(Ship ship) {
        displayGrid.placeShips(List.of(ship));
        IO.println(displayGrid.display());
    }
}
