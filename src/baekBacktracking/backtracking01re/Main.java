package baekBacktracking.backtracking01re;

import java.util.Scanner;

public class Main {
    public static int number;
    public static int sum;
    public static int count;
    public static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        sum = scanner.nextInt();
        numbers = new int[number];
        count = 0;

        for(int i = 0; i < number; i++) {
            numbers[i] = scanner.nextInt();
        }

        for(int i = 0; i < number; i++) {
            find(numbers[i], i);
        }

        System.out.println(count);
    }

    public static void find(int currentNumber, int level) {
        if(level == number - 1 && currentNumber == sum) {
            count++;
        }

        level++;

        if(level < number) {
            find(currentNumber + numbers[level], level);
            find(currentNumber, level);
        }
    }
}
