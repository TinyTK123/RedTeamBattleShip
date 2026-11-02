public class AutomaticShipFactory extends ShipFactory {
    
    @Override
    protected Coordinate getStartCoordinate(Ship ship) {
        return Coordinate.randomCoordinate();
    }

    @Override 
    protected Direction getStartDirection(Ship ship) {
        return Direction.randomDirection();
    }
}
