public class ManualShipFactory extends ShipFactory {
    @Override
    protected Coordinate getStartCoordinate(Ship ship) {
        while (true) {
            Coordinate startCoordinate;
            try {
                System.out.println(String.format("Currently placing: %s", ship.getName()));
                String playerInput = ConsoleHelper.getInput("Please select a starting coordinate.");
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
        String prompt = String.format("Currently placing: %s\nSelect the corresponding number to choose a direction: \n1. North\n2. South\n3. East\n4. West", ship.getName());
        return Direction.equivalentTo(ConsoleHelper.getNumberBetween(prompt, 1, 4));
    }
}
