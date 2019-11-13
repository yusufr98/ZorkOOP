import java.util.*;

public class Main {
    private static Room[][] rooms;
    private static ArrayList<String> items = new ArrayList<>();//list of potential items
    private static ArrayList<Room> allRooms = new ArrayList<>();//list of all rooms(for teddy, not implemented yet)
    private static Random r = new Random();
    public static void main(String[] args) {
        Collections.addAll(items,"skeleton", "bag of blood", "sword", "witch", "portal to the underworld", "dead rat", "vat of human feces", "creepy teddy bear", "clone of yourself", "Popeye's Chicken Sandwich");
        Scanner k = new Scanner(System.in);

        System.out.println("This is a directional adventure game. The goal is to find the secret room. " +
                "From your starting room in the foyer you can move in any direction using N,S, E, or W. Any other key will cause an error, good luck!");
        System.out.println("Welcome to Zork! Type QUIT at any time to quit the game.");
        System.out.print("Enter grid size: ");
        int g = k.nextInt();// allow user to select grid size
        rooms = new Room[g][g];
        boolean end = true;
        int userMoney = 0;
        Room current = initialize(); // call method to randomly initialize random amount of rooms, return Room 1

        while(end){ //moving through rooms, it ends if quit is entered
            rooms[current.getRow()][current.getCol()].setVisit(true);//set boolean visit to true
            String d;
            boolean repeat = true;
            System.out.println("You are in Room " + current.getIndex() + ". You have $" + userMoney + ".");
            if(current.getMoney() != 0){//show user the money available in the room
                System.out.println("You found " +  current.getMoney() + " dollars!");
                System.out.println("Would you like to take the money(yes/no)?");
                String s = k.next();
                if(s.equalsIgnoreCase("yes")){
                    userMoney+=current.getMoney();
                    rooms[current.getRow()][current.getCol()].setMoney(0);//add money to user and set room's money to zero
                }
            }
            for(Room[]array : rooms){//nested for loops to print map
                for(Room room : array ){
                    if (room == null){
                        System.out.print("??????\t" );//if room is null or visit=false then show ???
                    } else if(!room.isVisit()){
                        System.out.print("??????\t" );
                    } else {
                        System.out.print("Room " + room.getIndex() + "\t");//otherwise show Room number
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
                        if((rooms[current.getRow()-1][current.getCol()]) == null){//if chosen direction does not contain room sout invalid direction
                            System.out.println("Invalid direction");
                        }
                        else{
                            current = rooms[current.getRow()-1][current.getCol()];//set current to chosen room after direction is validated
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
                            current = rooms[current.getRow()+1][current.getCol()];
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
                            current = rooms[current.getRow()][current.getCol()-1];
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
                            current = rooms[current.getRow()][current.getCol()+1];
                            repeat = false;
                        }
                    }
                } else if (d.equalsIgnoreCase("quit")) {
                    end = false;
                    repeat = false;
                }
            } while (repeat);
        }
    }
    public static Room initialize(){//method to randomly generate rooms
        int index = r.nextInt(items.size());
        Room first = new Room(r.nextInt(rooms[0].length), r.nextInt(rooms[0].length), 1,items.get(index));//randomly create first room with any location
        items.remove(index);
        rooms[first.getRow()][first.getCol()] = first;//set room to correct location in grid
        int maxRooms = (rooms[0].length * rooms[0].length);
        int minRooms = maxRooms/2;
        int number = minRooms + r.nextInt(minRooms-(maxRooms/3));//randomly generate a number of rooms between 50%-66.7% of max number of rooms
        for (int i = 0; i < number; i++) {  // create rooms based on last calc
            boolean repeat = true;
            int c, ro;
            do {
                c = r.nextInt(rooms[0].length);//randomly select coordinates
                ro = r.nextInt(rooms[0].length);
                if (rooms[ro][c] != null) { // checks if chosen coordinates are already taken, continues to next while iteration if true
                    continue;
                }
                if (ro == rooms[0].length-1) {//checks last row
                    if (c == 0) {//checks bottom left corner
                        if (rooms[ro - 1][c] != null || rooms[ro][c + 1] != null) { // if room ro(3)co(0) - ro -1, co +1 = null, boolean is false
                            repeat = false;
                        }
                    } else if (c == rooms[0].length-1) {//checks bottom right corner
                        if (rooms[ro - 1][c] != null || rooms[ro][c - 1] != null) {
                            repeat = false;
                        }
                    } else if (rooms[ro][c - 1] != null || rooms[ro - 1][c] != null || rooms[ro][c + 1] != null) {//checks other bottom row cells
                        repeat = false;
                    }
                } else if (c == rooms[0].length-1) {//checks last column
                    if (ro == 0) {//checks top right corner
                        if (rooms[ro][c - 1] != null || rooms[ro + 1][c] != null) {
                            repeat = false;
                        }
                    } else if (rooms[ro][c - 1] != null || rooms[ro + 1][c] != null || rooms[ro - 1][c] != null) {
                        repeat = false;
                    }
                } else if (ro == 0) {//checks first row
                    if (c == 0) {//checks top left corner
                        if (rooms[ro + 1][c] != null || rooms[ro][c + 1] != null) {
                            repeat = false;
                        }
                    } else if (rooms[ro][c - 1] != null || rooms[ro + 1][c] != null || rooms[ro][c + 1] != null) {
                        repeat = false;
                    }
                } else if (c == 0) {//checks first column
                    if (rooms[ro - 1][c] != null || rooms[ro][c + 1] != null || rooms[ro + 1][c] != null) {
                        repeat = false;
                    }
                } else if (rooms[ro][c - 1] != null || rooms[ro - 1][c] != null || rooms[ro + 1][c] != null || rooms[ro][c + 1] != null) {
                    repeat = false;
                }
            } while (repeat);
            boolean bool = true;
            int x = r.nextInt(items.size());
            rooms[ro][c] = new Room(ro, c, i+2, items.get(x));//sets validated random location to sequential index starting at 2
            allRooms.add(rooms[ro][c]);
        }
        return first;
    }
}
