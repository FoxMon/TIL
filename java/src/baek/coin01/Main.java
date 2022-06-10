package baek.coin01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] coin = new int[n + 1];
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for(int i = 1; i < coin.length; i++) {
            coin[i] = scanner.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            for(int j = coin[i]; j <= k; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
