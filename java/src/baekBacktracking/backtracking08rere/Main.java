package baekBacktracking.backtracking08rere;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int number;
    public static ArrayList<Integer> results;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        results = new ArrayList<>();

        if(number <= 10) {
            System.out.println(number);
            System.exit(0);
        } else if(number > 1022) {
            System.out.println(-1);
            System.exit(0);
        } else {
            for(int i = 0; i < 10; i++) {
                find(i, 0);
            }

            Collections.sort(results);
            System.out.println(results.get(number));
        }
    }

    private static void find(int nums, int level) { // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        if(level >= 10) {
            return;
        }

        results.add(nums);
        for(int i = 0; i < nums % 10; i++) {
            find((nums * 10) + i, level + 1);
        }
    }
}
