import java.util.ArrayList;
import java.util.List;

public class Ship {
    private String name;
    private int length;
    private List<Coordinate> coords = new ArrayList<>();
    private List<Coordinate> hits = new ArrayList<>();

    public Ship(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public void setCoordinates(List<Coordinate> coords) {
        this.coords = coords;
    }

    public List<Coordinate> getCoords() {
        return coords;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public void registerHit(Coordinate coord){
        hits.add(coord);
    }

    public Boolean isSunk(){
        if (hits.size() == length){
            return true;
        } else {
            return false;
        }
    }
}
