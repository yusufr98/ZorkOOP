package com.company;

import java.util.Random;

public class Room {
    private String name;
    private String item;
    private int index;
    private int money;
    private int north, south, east , west;
    Random r = new Random();
    private boolean visit;
    private boolean teddy;

    Room(String name, int index, int north, int south, int east, int west) {
        this.name = name;
        this.index = index;
        this.money = 1 + r.nextInt(1000);
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        visit = false;
        teddy = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getNorth() {
        return north;
    }

    public void setNorth(int north) {
        this.north = north;
    }

    public int getSouth() {
        return south;
    }

    public void setSouth(int south) {
        this.south = south;
    }

    public int getEast() {
        return east;
    }

    public void setEast(int east) {
        this.east = east;
    }

    public int getWest() {
        return west;
    }

    public void setWest(int west) {
        this.west = west;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public boolean isVisit() {
        return visit;
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
    }

    public boolean isTeddy() {
        return teddy;
    }

    public void setTeddy(boolean teddy) {
        this.teddy = teddy;
    }
}

