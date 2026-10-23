public class Grid {
    private Cell[][] cells = new Cell[10][10];

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
            // this creates line 1
            String line1 = "";
            for (int cell = 0; cell < 10; cell++) {
                if (cell == 0) {
                    String substring = "| " + rowHeaders[rowIndex] + " ";
                    line1 = line1 + substring;
                } else {
                    // Cells in the final column need to be built with extra space, since the
                    // column header is a 2 digit number (10), rather than a 1 digit number
                    String substring = "|   ";
                    line1 = line1 + substring;
                }
            }
            line1 = line1 + "|    |";
            
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
}
