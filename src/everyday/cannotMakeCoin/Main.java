package everyday.cannotMakeCoin;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] coins = new int[count];

        for(int i = 0; i < coins.length; i++) {
            coins[i] = scanner.nextInt();
        }

        Arrays.sort(coins);
        int target = 1;

        for(int coin : coins) {
            if(target < coin) {
                break;
            } else {
                target += coin;
            }
        }

        System.out.println(target);
    }
}
