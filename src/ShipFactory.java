import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class ShipFactory {
    public List<Ship> getShips(){
        // make my five ships
        Ship ship1 = new Ship("Carrier", 5);
        Ship ship2 = new Ship("Battleship", 4);
        Ship ship3 = new Ship("Crusier", 3);
        Ship ship4 = new Ship("Submarine", 3);
        Ship ship5 = new Ship("Destroyer", 2);
        List<Ship> ships = List.of(ship1, ship2, ship3, ship4, ship5);
        
        Set<Coordinate> existing = new HashSet<>();
        for (Ship ship: ships){
            while (true){
                try {
                    Coordinate start = getStartCoordinate(ship);
                    Direction dir = getStartDirection(ship);
                    List<Coordinate> coords = start.coordsInDirection(ship.getLength(), dir);
                    if(coordinatesOverlapExistingCoordinates(coords, existing)){
                        placementRejected(ship, String.format("Invalid placement: %s is overlapping with another ship.", ship.getName()));
                        continue;
                    }
                    ship.setCoordinates(coords);
                    for (Coordinate coord:ship.getCoords()) {
                        existing.add(coord);
                    }
                    placementAccepted(ship);
                    break;
                } catch (Exception e) {
                    // bad coords - try again
                    continue;
                }
            }
        }
        return ships;
    }

    protected abstract Coordinate getStartCoordinate(Ship ship);
    protected abstract Direction getStartDirection(Ship ship);

    protected boolean coordinatesOverlapExistingCoordinates(List<Coordinate> placing, Set<Coordinate> existing){
        for(Coordinate c : placing){
            if (existing.contains(c)){
                return true;
            }
        }
        return false;
    }

    protected void placementRejected(Ship ship, String reason) {
        // overridden in manual, automatic is empty
    }

    protected void placementAccepted(Ship ship) {
        // overridden in manual, automatic is empty
    }
}
