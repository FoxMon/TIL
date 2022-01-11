package baekBacktracking.backtracking08re;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static ArrayList<Long> list;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        list = new ArrayList<>();

        if(number <= 10) {
            System.out.println(number);
        } else if(number > 1022) {
            System.out.println(-1);
        } else {
            for(int i = 0; i < 10; i++) {
                find(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(number));
        }
    }

    private static void find(long number, int level) {
        if(level >= 10) {
            return;
        }

        list.add(number);
        for(int i = 0; i < number % 10; i++) {
            find((number * 10) + i, level + 1);
        }
    }
}
