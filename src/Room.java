

import java.util.Random;

public class Room {
   private int row;
   private int col;
   private int index;

    public Room() {
    }

    public Room(int row, int col, int index) {
        this.col = col;
        this.row = row;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}

