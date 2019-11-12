import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Room[][] rooms = new Room[4][4];
    public static void main(String[] args) {
        Random r = new Random();
        Scanner k = new Scanner(System.in);
        Room first = new Room(r.nextInt(4), r.nextInt(4), 1); // first room created with the coordinates bound
        rooms[first.getRow()][first.getCol()] = first;
        for (int i = 0; i < 9; i++) {  // we know we have ten rooms
            boolean repeat = true;
            int c, ro;
            do {
                c = r.nextInt(4);
                ro = r.nextInt(4);
                if (rooms[ro][c] != null) { // protects from generating a room outside of the MdArrayList
                    continue;
                }
                if (ro == 3) {
                    if (c == 0) {
                        if (rooms[ro - 1][c] != null || rooms[ro][c + 1] != null) { // if room ro(3)co(0) - ro -1, co +1 = null, boolean is false
                            repeat = false;
                        }
                    } else if (c == 3) {
                        if (rooms[ro - 1][c] != null || rooms[ro][c - 1] != null) {
                            repeat = false;
                        }
                    } else if (rooms[ro][c - 1] != null || rooms[ro - 1][c] != null || rooms[ro][c + 1] != null) {
                        repeat = false;
                    }
                } else if (c == 3) {
                    if (ro == 0) {
                        if (rooms[ro][c - 1] != null || rooms[ro + 1][c] != null) {
                            repeat = false;
                        }
                    } else if (rooms[ro][c - 1] != null || rooms[ro + 1][c] != null || rooms[ro - 1][c] != null) {
                        repeat = false;
                    }
                } else if (ro == 0) {
                    if (c == 0) {
                        if (rooms[ro + 1][c] != null || rooms[ro][c + 1] != null) {
                            repeat = false;
                        }
                    } else if (rooms[ro][c - 1] != null || rooms[ro + 1][c] != null || rooms[ro][c + 1] != null) {
                        repeat = false;
                    }
                } else if (c == 0) {
                    if (rooms[ro - 1][c] != null || rooms[ro][c + 1] != null || rooms[ro + 1][c] != null) {
                        repeat = false;
                    }
                } else if (rooms[ro][c - 1] != null || rooms[ro - 1][c] != null || rooms[ro + 1][c] != null || rooms[ro][c + 1] != null) {
                    repeat = false;
                }
            } while (repeat);
            rooms[ro][c] = new Room(ro, c, i+2);
        }

        System.out.println("This is a directional adventure game. The goal is to find the secret room. " +
                "From your starting room in the foyer you can move in any direction using N,S, E, or W. Any other key will cause an error, good luck!");
        System.out.println("Welcome to Zork! Type QUIT at any time to quit the game.");

        boolean end = true;
        Room current = first; // the room you are currently in
        while(end){ //moving through rooms, it ends if quit is entered
            String d;
            boolean repeat = true;
            System.out.println("You are in Room " + current.getIndex() +"(" + current.getRow() + ", " + current.getCol() + ")");
            for(Room[]array : rooms){
                for(Room room : array ){
                    if (room == null){
                        System.out.print("empty\t" );
                    }else {
                        System.out.print("Room" + room.getIndex() + "\t");
                    }
                }
                System.out.println();
            }
            do {//choose direction, it repeats if invalid direction was chosen
                System.out.println("Which direction would you like to go in?");
                d = k.next();
                if (d.equalsIgnoreCase("n")) {
                    if(current.getRow() == 0){ // if your row is at zero it is impossible to go farther south // therefore invalid direction
                        System.out.println("Invalid direction");
                    }
                    else{
                        if((rooms[current.getRow()-1][current.getCol()]) == null){
                            System.out.println("Invalid direction");
                        }
                        else{
                            Room temp = new Room(current.getRow()-1, current.getCol(), rooms[current.getRow()-1][current.getCol()].getIndex());
                            current = temp;
                            repeat = false;
                        }
                    }
                } else if (d.equalsIgnoreCase("s")) {
                    if(current.getRow() == 3){
                        System.out.println("Invalid direction");
                    }
                    else{
                        if((rooms[current.getRow()+1][current.getCol()]) == null){
                            System.out.println("Invalid direction");
                        }
                        else{
                            Room temp = new Room(current.getRow()+1, current.getCol(), rooms[current.getRow()+1][current.getCol()].getIndex());
                            current = temp;
                            repeat = false;
                        }
                    }
                } else if (d.equalsIgnoreCase("w")) {
                    if(current.getCol() == 0){
                        System.out.println("Invalid direction");
                    }
                    else{
                        if((rooms[current.getRow()][current.getCol()-1]) == null){
                            System.out.println("Invalid direction");
                        }
                        else{
                            Room temp = new Room(current.getRow(), current.getCol()-1, rooms[current.getRow()][current.getCol()-1].getIndex());
                            current = temp;
                            repeat = false;
                        }
                    }
                } else if (d.equalsIgnoreCase("e")) {
                    if(current.getCol() == 3){
                        System.out.println("Invalid direction");
                    }
                    else{
                        if((rooms[current.getRow()][current.getCol()+1]) == null){
                            System.out.println("Invalid direction");
                        }
                        else{
                            Room temp = new Room(current.getRow(), current.getCol()+1, rooms[current.getRow()][current.getCol()+1].getIndex());
                            current = temp;
                            repeat = false;
                        }
                    }
                } else if (d.equalsIgnoreCase("quit")) {
                    end = false;
                }
            } while (repeat);
        }
    }
}
