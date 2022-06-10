package everyday.riceCake;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cakeCount = scanner.nextInt();
        int target = scanner.nextInt();
        int[] riceCakes = new int[cakeCount];

        for(int i = 0; i < riceCakes.length; i++) {
            riceCakes[i] = scanner.nextInt();
        }

        Arrays.sort(riceCakes);
        System.out.println(binarySearch(riceCakes, target));
    }

    public static int binarySearch(int[] riceCakes, int target) {
        int mid;
        int start = 0;
        int end = riceCakes[riceCakes.length - 1];
        int length = 0;

        while(start <= end) {
            length = 0;
            mid = (start + end) / 2;

            for(int cake : riceCakes) {
                if(mid < cake) {
                    length += cake - mid;
                }
            }

            if(length < target) {
                end = mid - 1;
            } else {
                length = mid;
                start = mid + 1;
            }
        }

        return riceCakes[riceCakes.length - 1] - length;
    }
}
