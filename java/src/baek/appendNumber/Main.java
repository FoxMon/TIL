package baek.appendNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long result = 0;
        int count = 1;
        int divide = 10;

        for(int i = 1; i <= n; i++) {
            if(i % divide == 0) {
                divide *= 10;
                count++;
            }

            result += count;
        }

        System.out.println(result);
    }
}
