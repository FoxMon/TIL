package baekBacktracking.backtracking01rere;

import java.util.Scanner;

public class Main {
    public static int number;
    public static int sum;
    public static int cnt;
    public static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        sum = scanner.nextInt();
        numbers = new int[number];
        cnt = 0;

        for(int i = 0; i < number; i++) {
            numbers[i] = scanner.nextInt();
        }

        for(int i = 0; i < number; i++) {
            find(numbers[i], i);
        }

        System.out.println(cnt);
    }

    public static void find(int target, int level) {
        if(level == number - 1 && target == sum) {
            cnt++;
            return;
        }

        level++;
        if(level < number) {
            find(target + numbers[level], level);
            find(target, level);
        }
    }
}
