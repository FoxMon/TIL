package baek.installWiFi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        long[] home = new long[n];

        for(int i = 0; i < n; i++) {
            home[i] = scanner.nextInt();
        }

        Arrays.sort(home);
        long start = 1;
        long end = home[n - 1] - home[0];
        long result = 0;

        while(start <= end) {
            long mid = (start + end) / 2;
            long value = home[0];
            int count = 1;

            for(int i = 0; i < n; i++) {
                if(home[i] >= value + mid) {
                    value = home[i];
                    count++;
                }
            }

            if(count >= c) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
