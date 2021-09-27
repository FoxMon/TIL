package baek.makeLan;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lanCount = scanner.nextInt();
        int hope = scanner.nextInt();
        int[] lans = new int[lanCount];

        for(int i = 0; i < lans.length; i++) {
            lans[i] = scanner.nextInt();
        }

        Arrays.sort(lans);

        long start = 1;
        long end = lans[lans.length - 1];
        long mid = 0;

        while(start <= end) {
            long result = 0;
            mid = (start + end) / 2;

            for(int lan : lans) {
                result += lan / mid;
            }

            if(result >= hope) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
