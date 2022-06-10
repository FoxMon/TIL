package baek.dpFunction;

import java.util.Scanner;

public class Main {
    public static int[][][] memo = new int[21][21][21];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            if(a == -1 && b == -1 && c == -1) {
                return;
            }

            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
        }
    }

    public static int w(int a, int b, int c) {
        if((0 <= a && a <= 20) &&
                (0 <= b && b <= 20) && (0 <= c && c <= 20) && (memo[a][b][c] != 0)) {
            return memo[a][b][c];
        }

        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if(a > 20 || b > 20 || c > 20) {
            return memo[20][20][20] = w(20, 20, 20);
        }

        if(a < b && b < c) {
            return  memo[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return memo[a][b][c] =  w(a - 1, b, c) + w(a - 1, b - 1, c)
                + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}
