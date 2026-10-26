public enum ShotResult {
    Hit,
    Miss,
    Sunk;

    private String shipName = null;
    private Coordinate shot = null;

    public String GetShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public Coordinate getShot() {
        return shot;    }

    public void setShot(Coordinate shot) {
        this.shot = shot;
    }
}