package baekBacktracking.backtracking10re;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int number;
    public static String target;
    public static ArrayList<Integer> results;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        results = new ArrayList<>();
        target = "";
        find(target, 0);
        StringBuilder stringBuilder = new StringBuilder();
        Collections.sort(results);
        for(int result : results) {
            stringBuilder.append(result + "\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private static void find(String result, int level) {
        if(level >= number) {
            int num = Integer.parseInt(result);
            results.add(num);
            return;
        }

        for(int i = 1; i < 10; i++) {
            if(isPrime(result + i)) {
                find(result + i, level + 1);
            }
        }
    }

    private static boolean isPrime(String result) {
        int num = Integer.parseInt(result);
        if(num <= 1) {
            return false;
        }

        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
