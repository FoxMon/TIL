package everyday.riceCake02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cakeSize = scanner.nextInt();
        int target = scanner.nextInt();
        int[] cakes = new int[cakeSize];

        for(int i = 0; i < cakes.length; i++) {
            cakes[i] = scanner.nextInt();
        }

        Arrays.sort(cakes);
        System.out.println(findCakes(cakes, target));
    }

    public static int findCakes(int[] cakes, int target) {
        int start = 0;
        int mid;
        int end = cakes[cakes.length - 1];
        int result = 0;

        while(start <= end) {
            result = 0;
            mid = (start + end) / 2;

            for(int cake : cakes) {
                if(mid < cake) {
                    result += cake - mid;
                }
            }

            if(result < target) {
                end = mid - 1;
            } else {
                result = start;
                start = mid + 1;
            }
        }

        return cakes[cakes.length - 1] - result;
    }
}
