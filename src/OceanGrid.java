import java.util.ArrayList;
import java.util.List;

public class OceanGrid extends Grid {
    private List<Ship> ships = new ArrayList<>();
    
    public OceanGrid(int rows, int cols) {
        super(rows, cols);
    }
}