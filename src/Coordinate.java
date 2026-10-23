import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coordinate {
    private int row;
    private int column;

    public Coordinate(String position) throws Exception {
        String normalizedPosition = position.toLowerCase();
        this.row = rowForHumanValue(normalizedPosition);
        this.column = columnForHumanValue(normalizedPosition);
    }

    public Coordinate(int row, int column) throws Exception {
        if (row < 0 || row > 9){
            throw new Exception("Invalid row for coordinate.");
        }
        if (column < 0 || column > 9){
            throw new Exception("Invalid column for coordinate.");
        }
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override 
    public String toString() {
        char firstChar = (char)(row + 97); // ascii for little a is 97
        String result = Character.toString(firstChar) + Integer.toString(column + 1);
        return result.toUpperCase();
    }

    private int rowForHumanValue(String input) throws Exception {
        char firstChar = input.charAt(0);
        int asciiValue = (int)firstChar;
        int row = asciiValue - 97; //ascii value of "a" is 97
        if (row < 0 || row > 9){
            throw new Exception("Invalid row for coordinate.");
        }
        return row;
    }

    private int columnForHumanValue(String input) throws Exception {
        String columnPortion = input.substring(1);
        int column = Integer.parseInt(columnPortion);
        column -= 1; //switch from 1-index to 0-index
        if (column < 0 || column > 9){
            throw new Exception("Invalid column for coordinate.");
        }
        return column;
    }

    public List<Coordinate> coordsInDirection(int numberOfTiles, Direction direction) {
        List<Coordinate> listOfCoordinates = new ArrayList<>();
        if (direction == Direction.SOUTH) {
            for (int i = 0; i < numberOfTiles; i++) {
                try {
                    listOfCoordinates.add(new Coordinate(this.row + i, this.column));
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                }
            }
            //create new coordinates with row values higher than input coordinate, including input coordinate
        }
        else if (direction == Direction.NORTH) {
            for (int i = 0; i < numberOfTiles; i++) {
                try {
                    listOfCoordinates.add(new Coordinate(this.row - i, this.column));
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                }
            }
            //create new coordinates with row values lower than input coordinate, including input coordinate
        }
        else if (direction == Direction.WEST) {
            for (int i = 0; i < numberOfTiles; i++) {
                try {
                    listOfCoordinates.add(new Coordinate(this.row, this.column - i));
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                }
            }
            //create new coordinates with column values lower than input coordinate, including input coordinate
        }
        else if (direction == Direction.EAST) {
            for (int i = 0; i < numberOfTiles; i++) {
                try {
                    listOfCoordinates.add(new Coordinate(this.row, this.column + i));
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                }
            }
            //create new coordinates with columns values higher than input coordinate, including input coordinate
        }
        return listOfCoordinates;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Coordinate coordinate = (Coordinate) o;
        // field comparison
        return Objects.equals(row, coordinate.row) && Objects.equals(column, coordinate.column);
    }
}
