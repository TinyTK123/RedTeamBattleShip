public interface Player {
    // just listing the methods that this needs to DO. 
    // by default all of these are public
    String getName();
    Coordinate takeShot();
    ShotResult receiveShot(Coordinate c);
    void receiveShotResult(ShotResult result);
    boolean shipsAreSunk();
    void placeShip();
}
