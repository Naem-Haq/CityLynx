package Map;

public class TaxiLocation {
    private int currentRow;
    private int currentCol;

    public TaxiLocation(int initialRow, int initialCol) {
        this.currentRow = initialRow;
        this.currentCol = initialCol;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void updateLocation(int newRow, int newCol) {
        if (isValidLocation(newRow, newCol)) {
            this.currentRow = newRow;
            this.currentCol = newCol;
        } else {
            System.out.println("Invalid location. Taxi location not updated.");
        }
    }

    private boolean isValidLocation(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }
}
