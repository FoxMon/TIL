package baek.findNumber;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();
        int[] numbers = new int[numberCount];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int findNumberCount = scanner.nextInt();
        int[] finds = new int[findNumberCount];

        for(int i = 0; i < finds.length; i++) {
            finds[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        for(int i = 0; i < finds.length; i++) {
            System.out.println(findNumber(numbers, finds[i]));
        }
    }

    public static int findNumber(int[] numbers, int target) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        int mid;
        int result = -1;

        while(startIndex <= endIndex) {
            mid = (startIndex + endIndex) / 2;

            if(target == numbers[mid]) {
                result = mid;
                break;
            }

            if(target < numbers[mid]) {
                endIndex = mid - 1;
            }

            if(target > numbers[mid]) {
                startIndex = mid + 1;
            }
        }

        if(result != -1) {
            return 1;
        } else {
            return 0;
        }
    }
}
