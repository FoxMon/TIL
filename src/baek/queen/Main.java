package baek.queen;

import java.util.Scanner;

public class Main {
    public static int count = 0;
    public static int map;
    public static int[] queens;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        map = scanner.nextInt();
        queens = new int[map];

        backTracking(0);
        System.out.println(count);
    }

    public static void backTracking(int level) {
        if(level >= map) {
            count++;
            return;
        }

        for(int i = 0; i < map; i++) {
            queens[level] = i;

            if(isPossible(queens, level)) {
                backTracking(level + 1);
            }
        }
    }

    public static boolean isPossible(int[] queens, int col) {
        for(int i = 0; i < col; i++) {
            if(queens[col] == queens[i]) {
                return false;
            } else if(Math.abs(col - i) == Math.abs(queens[col] - queens[i])) {
                return false;
            }
        }

        return true;
    }
}
