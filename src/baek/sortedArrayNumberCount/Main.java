package baek.sortedArrayNumberCount;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();
        int target = scanner.nextInt();
        int[] numbers = new int[count];

        for(int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        System.out.println(findEnd(numbers, target, 0, count - 1) - findFirst(numbers, target, 0, count - 1) + 1);
    }

    public static int findFirst(int[] numbers, int target, int start, int end) {
        if(start > end) {
            return 0;
        }

        int mid = (start + end) / 2;

        if((mid == 0 || target > numbers[mid - 1]) && numbers[mid] == target) {
            return mid;
        } else if(numbers[mid] >= target) {
            return findFirst(numbers, target, start, mid - 1);
        } else {
            return findFirst(numbers, target, mid + 1, end);
        }
    }

    public static int findEnd(int[] numbers, int target, int start, int end) {
        if(start > end) {
            return 0;
        }

        int mid = (start + end) / 2;

        if((mid == count - 1 || target < numbers[mid + 1]) && numbers[mid] == target) {
            return mid;
        } else if(numbers[mid] > target) {
            return findEnd(numbers, target, start, mid - 1);
        } else {
            return findEnd(numbers, target, mid + 1, end);
        }
    }
}
