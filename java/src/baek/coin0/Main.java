package baek.coin0;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int money = scanner.nextInt();
        int result = 0;
        int[] moneys = new int[count];

        for(int i = 0; i < moneys.length; i++) {
            moneys[i] = scanner.nextInt();
        }

        for(int i = moneys.length - 1; i >= 0; i--) {
            if(money == 0) {
                break;
            }
            while(money >= moneys[i]) {
                money -= moneys[i];
                result++;
            }
        }

        System.out.println(result);
    }
}
