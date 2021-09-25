package everyday.arraySumSwap;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int swapCount = scanner.nextInt();
        int[] first = new int[arraySize];
        int[] second = new int[arraySize];

        for(int i = 0; i < first.length; i++) {
            first[i] = scanner.nextInt();
        }

        for(int i = 0; i < second.length; i++) {
            second[i] = scanner.nextInt();
        }

        Arrays.sort(first);
        Arrays.sort(second);

        for(int i = 0; i < swapCount; i++) {
            first[i] = second[arraySize - i - 1];
        }

        int result = 0;

        for(int number : first) {
            result += number;
        }

        System.out.println(result);
    }
}
