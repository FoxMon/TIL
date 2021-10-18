package baek.zeroCountCombi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long five = powerN(n) - powerN(n - m) - powerN(m);
        long two = powerM(n) - powerM(n - m) - powerM(m);
        System.out.println(Math.min(five, two));
    }

    public static long powerN(long num) {
        long count = 0;

        while(num >= 5) {
            count += (num / 5);
            num /= 5;
        }

        return count;
    }

    public static long powerM(long num) {
        long count = 0;

        while(num >= 2) {
            count += (num / 2);
            num /= 2;
        }

        return count;
    }
}