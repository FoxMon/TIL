package baek.queenStudy01;

import java.util.Scanner;

public class Main {
    public static int[] queens;
    public static int map;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        map = scanner.nextInt();
        queens = new int[map];

        makeMap(0);
        System.out.println(count);
    }

    public static void makeMap(int level) {
        if(level >= map) {
            count++;
            return;
        }

        for(int i = 0; i < map; i++) {
            queens[level] = i;

            if(isPossible(queens, level)) {
                makeMap(level + 1);
            }
        }
    }

    public static boolean isPossible(int[] queens, int col) {
        for(int i = 0; i < col; i++) {
            if(queens[i] == queens[col]) {
                return false;
            } else if(Math.abs(col - i) == Math.abs(queens[i] - queens[col])) {
                return false;
            }
        }

        return true;
    }
}
