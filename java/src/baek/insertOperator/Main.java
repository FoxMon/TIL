package baek.insertOperator;

import java.util.Scanner;

public class Main {
    public static int[] operators = new int[4];
    public static int[] numbers;
    public static int numberCount;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numberCount = scanner.nextInt();
        numbers = new int[numberCount];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        for(int i = 0; i < operators.length; i++) {
            operators[i] = scanner.nextInt();
        }

        insertOperator(numbers[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void insertOperator(int number, int level) {
        if(level >= numberCount) {
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }

        for(int i = 0; i < operators.length; i++) {
            if(operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0:
                        insertOperator(number + numbers[level], level + 1);
                        break;

                    case 1:
                        insertOperator(number - numbers[level], level + 1);
                        break;

                    case 2:
                        insertOperator(number * numbers[level], level + 1);
                        break;

                    case 3:
                        insertOperator(number / numbers[level], level + 1);
                        break;
                }

                operators[i]++;
            }
        }
    }
}