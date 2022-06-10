package baek.dpUpStair02;

import java.util.Scanner;

public class Main {
    public static int[] stairs;
    public static Integer[] dpStairs;
    public static int stairCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        stairCount = scanner.nextInt();
        stairs = new int[stairCount + 1];
        dpStairs = new Integer[stairCount + 1];

        for(int i = 1; i < stairs.length; i++) {
            stairs[i] = scanner.nextInt();
        }

        dpStairs[0] = stairs[0];
        dpStairs[1] = stairs[1];

        if(stairCount >= 2) {
            dpStairs[2] = stairs[1] + stairs[2];
        }

        System.out.println(findMaxStairs(stairCount));
    }

    public static int findMaxStairs(int level) {
        if(dpStairs[level] == null) {
            dpStairs[level] = Math.max(findMaxStairs(level - 2), findMaxStairs(level - 3) + stairs[level - 1]) + stairs[level];
        }

        return dpStairs[level];
    }
}
