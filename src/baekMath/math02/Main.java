package baekMath.math02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        while(testCase-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.printf("%.0f\n", calc(m, n));
        }
    }

    public static double calc(int n, int m) {
        double first = 1;
        double last = 1;

        for(int i = n; i > n - m; i--) {
            first *= i;
        }

        for(int i = m; i > 0; i--) {
            last *= i;
        }
        return first / last;
    }
}
