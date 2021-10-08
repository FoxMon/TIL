package everyday.fixNumber;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];

        for(int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        System.out.println(find(numbers));
    }

    public static int find(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        int mid;

        while(start <= end) {
            mid = (start + end) / 2;

            if(numbers[mid] == mid) {
                return mid;
            } else if(numbers[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return - 1;
    }
}
