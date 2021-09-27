package everyday.makeNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] numbers = new int[number + 1];
        numbers[1] = 0;

        for(int i = 2; i <= number; i++) {
            numbers[i] = numbers[i - 1] + 1;

            if(i % 2 == 0) {
                numbers[i] = Math.min(numbers[i], numbers[i / 2] + 1);
            }

            if(i % 3 == 0) {
                numbers[i] = Math.min(numbers[i], numbers[i / 3] + 1);
            }

            if(i % 5 == 0) {
                numbers[i] = Math.min(numbers[i], numbers[i / 5] + 1);
            }
        }

        System.out.println(numbers[number]);
    }
}
