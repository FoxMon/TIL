package baek.numberSort01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int numberCount = scanner.nextInt();
        int[] numbers = new int[numberCount];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        for(int number : numbers) {
            stringBuilder.append(number + "\n");
        }

        System.out.print(stringBuilder.toString());
    }
}
