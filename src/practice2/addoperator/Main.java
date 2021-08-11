package practice2.addoperator;

import java.util.Scanner;

public class Main {
    static int[] numbers;
    static int[] operators = new int[4];
    static int number_count;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        number_count = scanner.nextInt();
        numbers = new int[number_count];

        for(int i = 0; i < number_count; i++) {
            numbers[i] = scanner.nextInt();
        }

        for(int i = 0; i < 4; i++) {
            operators[i] = scanner.nextInt();
        }

        dfs(numbers[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int num, int operator_idx) {
        if(operator_idx == number_count) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0:
                        dfs(numbers[operator_idx] + num, operator_idx+1);
                        break;
                    case 1:
                        dfs(numbers[operator_idx] - num, operator_idx+1);
                        break;
                    case 2:
                        dfs(numbers[operator_idx] * num, operator_idx+1);
                        break;
                    case 3:
                        dfs(numbers[operator_idx] / num, operator_idx+1);
                        break;
                }
                operators[i]++;
            }
        }
    }
}
