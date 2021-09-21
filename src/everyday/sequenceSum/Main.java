package everyday.sequenceSum;

import java.util.Scanner;

public class Main {
    public static int max;
    public static int numberCount;
    public static int[] numbers;
    public static Integer[] dpNumbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numberCount = scanner.nextInt();
        numbers = new int[numberCount];
        dpNumbers = new Integer[numberCount];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        dpNumbers[0] = numbers[0];
        max = numbers[0];
        getSum(numberCount - 1);

        System.out.println(max);
    }

    public static int getSum(int level) {
        if(dpNumbers[level] == null) {
            dpNumbers[level] = Math.max(getSum(level - 1) + numbers[level], numbers[level]);
            max = Math.max(dpNumbers[level], max);
        }

        return dpNumbers[level];
    }
}
