package everyday.cannotMakeCoin02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int[] money = new int[total];

        for(int i = 0; i < total; i++) {
            money[i] = scanner.nextInt();
        }

        Arrays.sort(money);
        int target = 1;

        for(int coin : money) {
            if(target < coin) {
                break;
            }

            target += coin;
        }

        System.out.println(target);
    }
}
