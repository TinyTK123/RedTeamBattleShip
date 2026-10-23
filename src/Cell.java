public class Cell {
    CellState cellstate = CellState.EMPTY;
    Ship ship;

    public CellState getCellstate() {
        return cellstate;
    }
    public void setCellstate(CellState cellstate) {
        this.cellstate = cellstate;
    }
    public Ship getShip() {
        return ship;
    }
    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
