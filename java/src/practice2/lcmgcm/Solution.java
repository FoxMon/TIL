package practice2.lcmgcm;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        System.out.println(gcm(num1, num2));
        System.out.println(lcm(num1, num2));
    }

    public static int gcm(int num1, int num2) {
        while(num2 != 0) {
            int remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }

        return num1;
    }

    public static int lcm(int num1, int num2) {
        return (num1 * num2) / gcm(num1, num2);
    }
}
