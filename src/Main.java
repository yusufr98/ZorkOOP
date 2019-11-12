import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner k = new Scanner(System.in);
        Room[][] rooms = new Room[4][4];
        Room first = new Room(r.nextInt(4), r.nextInt(4));
        rooms[first.getRow()][first.getCol()] = first;
        for (int i = 0; i < 9; i++) {
            boolean repeat = true;
            int c, ro;
            do {
                c = r.nextInt(4);
                ro = r.nextInt(4);
                if (rooms[ro][c] != null) {
                    continue;
                }
                if (ro == 3) {
                    if (c == 0) {
                        if (rooms[ro - 1][c] != null || rooms[ro][c + 1] != null) {
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
            rooms[ro][c] = new Room(ro, c);
        }
            for (int i = 0; i < rooms.length; i++) {
                System.out.println(Arrays.toString(rooms[i]));
            }
    }
}
