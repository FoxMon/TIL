package practice3.coinChangeProblem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int coin_count = scanner.nextInt();
        int money = scanner.nextInt();
        int[] coins = new int[coin_count]; // have coins
        int[] coin_dp = new int[money + 1]; // make coin for making money

        for(int i = 0; i < coin_count; i++) { // init coins
            coins[i] = scanner.nextInt();
        }

        for(int i = 1; i <= money; i++) {
            coin_dp[i] = -1;

            for(int j = 0; j < coin_count; j++) {
                if(coins[j] <= i) {
                    if(coin_dp[i - coins[j]] < 0) { // can't make money
                        continue;
                    }

                    if(coin_dp[i] < 0) {
                        coin_dp[i] = coin_dp[i - coins[j]] + 1;
                    } else if(coin_dp[i - coins[j]] + 1 < coin_dp[i]) {
                        coin_dp[i] = coin_dp[i - coins[j]] + 1;
                    }
                }
            }
        }

        System.out.println(coin_dp[money]);
    }
}
