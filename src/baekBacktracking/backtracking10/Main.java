package baekBacktracking.backtracking10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int number;
    public static boolean[] visited;
    public static String target;
    public static ArrayList<Integer> results;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        results = new ArrayList<>();
        target = "";
        find(target, 0);

        Collections.sort(results);
        StringBuilder stringBuilder = new StringBuilder();
        for(int result : results) {
            stringBuilder.append(result + "\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private static void find(String num, int level) {
        if(level >= number) {
            int result = Integer.parseInt(num);
            results.add(result);
            return;
        }

        for(int i = 1; i < 10; i++) {
            if(isPrime(num + i)) {
                find(num + i, level + 1);
            }
        }
    }

    private static boolean isPrime(String result) {
        int temp = Integer.parseInt(result);
        if(temp <= 1) {
            return false;
        }

        for(int i = 2; i < temp; i++) {
            if(temp % i == 0) {
                return false;
            }
        }

        return true;
    }
}
