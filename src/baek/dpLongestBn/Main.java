package baek.dpLongestBn;

import java.util.Scanner;

public class Main {
    public static int length;
    public static int[] numbers;
    public static Integer[] dpNumbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        length = scanner.nextInt();
        numbers = new int[length];
        dpNumbers = new Integer[length];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        for(int i = 1; i < length; i++) {
            find(i);
        }

        int max = dpNumbers[0];

        for(int i = 1; i < length; i++) {
            max = Math.max(max, dpNumbers[i]);
        }

        System.out.println(max);
    }

    public static int find(int level) {
        if(dpNumbers[level] == null) {
            dpNumbers[level] = 1;

            for(int i = level - 1; i >= 0; i--) {
                if(numbers[i] < numbers[level]) {
                    dpNumbers[level] = Math.max(dpNumbers[level], find(i) + 1);
                }
            }
        }

        return dpNumbers[level];
    }
}
