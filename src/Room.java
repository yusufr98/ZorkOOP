

import java.util.Random;

public class Room {
   private int row;
   private int col;
   private int index;
   private int money;
   private Random r = new Random();
   private boolean visit;
   private boolean teddy;
   private String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Room() {
    }

    public Room(int row, int col, int index, String item) {
        this.col = col;
        this.row = row;
        this.index = index;
        this.item = item;
        this.visit = false;
        this.money = 1 + r.nextInt(1000);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isTeddy() {
        return teddy;
    }

    public void setTeddy(boolean teddy) {
        this.teddy = teddy;
    }

    public boolean isVisit() {
        return visit;
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
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

