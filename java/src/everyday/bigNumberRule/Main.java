package everyday.bigNumberRule;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();
        int sumCount = scanner.nextInt();
        int sequence = scanner.nextInt();
        int[] numbers = new int[numberCount];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        int sum = 0;
        int count = 0;

        while(true) {
            for(int i = 0; i < sequence && count != sumCount; i++) {
                sum += numbers[numbers.length - 1];
                count++;
            }

            for(int i = 0; i < 1 && count != sumCount; i++) {
                sum += numbers[numbers.length - 2];
                count++;
            }

            if(count == sumCount) {
                break;
            }
        }

        System.out.println(sum);
    }
}
