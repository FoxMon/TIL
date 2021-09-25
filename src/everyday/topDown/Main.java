package everyday.topDown;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();
        Integer[] numbers = new Integer[numberCount];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers, Collections.reverseOrder());

        for(int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
