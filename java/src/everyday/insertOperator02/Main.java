package everyday.insertOperator02;

import java.util.Scanner;

public class Main {
    public static int[] operators = new int[4];
    public static int[] numbers;
    public static int count;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();
        numbers = new int[count];

        for(int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        for(int i = 0; i < operators.length; i++) {
            operators[i] = scanner.nextInt();
        }

        insert(numbers[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void insert(int number, int level) {
        if(level >= count) {
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }

        for(int i = 0; i < operators.length; i++) {
            if(operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case 0:
                        insert(number + numbers[level], level + 1);
                        break;

                    case 1:
                        insert(number - numbers[level], level + 1);
                        break;

                    case 2:
                        insert(number * numbers[level], level + 1);
                        break;

                    case 3:
                        insert(number / numbers[level], level + 1);
                        break;
                }
                operators[i]++;
            }
        }
    }
}
