package baek.lcm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int count = 0;

        while(count++ < input) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            System.out.println(lcm(num1, num2));
        }
    }

    public static int lcm(int num1, int num2) {
        return (num1 * num2) / gcm(num1, num2);
    }

    public static int gcm(int num1, int num2) {
        while(num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        return num1;
    }
}
