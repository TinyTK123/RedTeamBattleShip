public class Grid {
    private Cell[][] cells = new Cell[10][10];

    public Grid() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                cells[row][col] = new Cell();
            }
        }
    }

    public String display() {
        String result = this.generateGridColumnHeaders() + System.lineSeparator() + this.generateRowHeadersAndCells();
        return result;
    }

    private String generateGridColumnHeaders() {
        String[] columnHeaders = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        String line1 = "+---";
        for (int i = 0; i < 10; i++) {
            String substring = "+---";
            line1 = line1 + substring;
        }
        line1 = line1 + "-+";

        String line2 = "|   ";
        for (int i = 0; i < 10; i++) {
            String substring = String.format("| %s ", columnHeaders[i]);
            line2 = line2 + substring;
        }
        line2 = line2 + "|";

        String line3 = "+---";
        for (int i = 0; i < 10; i++) {
            String substring = "+---";
            line3 = line3 + substring;
        }
        line3 = line3 + "-+";

        String gridColumnHeaders = line1 + System.lineSeparator() + line2 + System.lineSeparator() + line3;
        return gridColumnHeaders;
    }

    private String generateRowHeadersAndCells() {
        // a row is made from two lines, like so:
        // line1:  |   |   |   |   |
        // line2:  +---+---+---+---+
        String[] rowHeaders = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String fullGrid = "";

        //this repeats 10 times, creating each row
        for (int rowIndex = 0; rowIndex < 10; rowIndex++) {
            // this creates line 1, starting with the row header
            String line1 = "";
            String rowHeader = "| " + rowHeaders[rowIndex] + " ";
            line1 = line1 + rowHeader;

            // now, create the ten columns for each row
            for (int columnIndex = 0; columnIndex < 10; columnIndex++) {
                if (columnIndex == 9) {
                    // Cells in the final column need to be built with extra space, since the
                    // column header is a 2 digit number (10), rather than a 1 digit number
                    String symbol = getCellSymbol(cells[rowIndex][columnIndex]);
                    line1 = line1 + "|  " + symbol + " |";
                } else {
                    // Checks the cellState of each cell, then fills the graphical display of
                    // that cell with a symbol depending on its state.
                    String symbol = getCellSymbol(cells[rowIndex][columnIndex]);
                    String substring = "| " + symbol + " ";
                    line1 = line1 + substring;
                }
            }
            
            // This creates line2
            String line2 = "+---";
            for (int cell = 0; cell < 10; cell++) {
                String substring = "+---";
                line2 = line2 + substring;
            }
            line2 = line2 + "-+";

            String row = line1 + System.lineSeparator() + line2;

            // avoids having a gap between the column headers and the first row.
            if (rowIndex == 0) {
                fullGrid = row;
            } else {
                fullGrid = fullGrid + System.lineSeparator() + row;
            }
        }
        return fullGrid;
    }

    public Cell getCellAtCoord(Coordinate coord) {
        // get the row of the coord and store it
        int row = coord.getRow();
        // get the col of the coord and store it
        int col = coord.getColumn();
        // fetch the cell in the cells array that matches the coord
        return cells[row][col];
    }

    private String getCellSymbol(Cell cell) {
        switch (cell.getCellstate()) {
            case HIT:
                return "X";
            case MISS:
                return "O";
            case OCCUPIED:
                return "S";
            case EMPTY:
                return " ";
            default:
                return " ";
        }
    }
}
