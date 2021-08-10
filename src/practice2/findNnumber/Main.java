package practice2.findNnumber;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int find = scanner.nextInt();
        int[] numbers = new int[10];
        int[] result = new int[find];

        for(int i = 0; i < find; i++) {
            for(int j = 0; j < 10; j++) {
                numbers[j] = scanner.nextInt();
            }

            Arrays.sort(numbers);
            result[i] = numbers[7];
        }

        for(int i = 0; i < find; i++) {
            System.out.println(result[i]);
        }
    }
}
