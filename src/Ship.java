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

    public boolean isSunk() {
        // check number of items in hits, if number of items is equal to length, then ship is sunk
        int numberOfHits = hits.size();
        if (numberOfHits == length) {
            return true;
        } else {
            return false;
        }
    }

    public void registerHit(Coordinate shot) {
        hits.add(shot);
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coords = coordinates;
    }

    public List<Coordinate> getCoordinates() {
        return coords;
    }

    public String getName() {
        return name;
    }

    public List<Coordinate> getHits() {
        return hits;
    }

    public int getLength() {
        return length;
    }
}
