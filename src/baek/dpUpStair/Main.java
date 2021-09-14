package baek.dpUpStair;

import java.util.Scanner;

public class Main {
    public static int[] stairs;
    public static Integer[] stairsDP;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stairCount = scanner.nextInt();
        stairs = new int[stairCount + 1];
        stairsDP = new Integer[stairCount + 1];

        for(int i = 1; i <= stairCount; i++) {
            stairs[i] = scanner.nextInt();
        }

        stairsDP[0] = stairs[0];
        stairsDP[1] = stairs[1];

        if(stairCount >= 2) {
            stairsDP[2] = stairs[1] + stairs[2];
        }

        System.out.println(findStairsSum(stairCount));
    }

    public static int findStairsSum(int level) {
        if(stairsDP[level] == null) {
            stairsDP[level] = Math.max(findStairsSum(level - 2), findStairsSum(level - 3) + stairs[level - 1]) + stairs[level];
        }

        return stairsDP[level];
    }
}
