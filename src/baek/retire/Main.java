package baek.retire;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int[] t = new int[total];
        int[] p = new int[total];
        int[] dp = new int[total + 1];

        for(int i = 0; i < total; i++) {
            t[i] = scanner.nextInt();
            p[i] = scanner.nextInt();
        }

        for(int i = 0; i < total; i++) {
            if(i + t[i] <= total) {
                dp[i + t[i]] = Math.max(dp[i+ t[i]], dp[i] + p[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[total]);
    }
}
