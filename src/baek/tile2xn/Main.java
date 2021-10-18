package baek.tile2xn;

import java.util.Scanner;

/*
* 2x1 -> 1
* 2x2 -> 2
* 2x3 -> 3
* 2x4 -> 5
* */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        if(count == 1) {
            System.out.println(count);
            return;
        }

        if(count == 2) {
            System.out.println(count);
            return;
        }

        int[] tiles = new int[count + 1];
        tiles[1] = 1;
        tiles[2] = 2;

        for(int i = 3; i <= count; i++) {
            tiles[i] = (tiles[i - 1] + tiles[i - 2]) % 10007;
        }

        System.out.println(tiles[count]);
    }
}
