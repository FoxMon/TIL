package baek.twoNumberSum;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();
        int[] numbers = new int[numberCount];
        int target;
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        int count = 0;

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        target = scanner.nextInt();

        while(startIndex < endIndex) {
            int sum = numbers[startIndex] + numbers[endIndex];

            if(sum == target) {
                count++;
            }

            if(sum <= target) {
                startIndex++;
            } else {
                endIndex--;
            }
        }

        System.out.println(count);
    }
}
