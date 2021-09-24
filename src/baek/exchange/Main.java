package baek.exchange;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] exchanges = { 500, 100, 50, 10, 5, 1 };
        int money = 1000;
        int count = 0;
        int input = scanner.nextInt();
        input = money - input;

        for(int i = 0; i < exchanges.length; i++) {
            count += input / exchanges[i];
            input %= exchanges[i];
        }

        System.out.println(count);
    }
}
