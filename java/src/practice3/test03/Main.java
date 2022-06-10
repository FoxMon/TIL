package practice3.test03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num1 = new int[2];
        int[] num2 = new int[2];

        for(int i = 0; i < num1.length; i++) {
            num1[i] = scanner.nextInt();
        }

        for(int i = 0; i < num2.length; i++) {
            num2[i] = scanner.nextInt();
        }

        System.out.println(product(num1, num2));
    }

    public static String product(int[] num1, int[] num2) {
        int x = (num1[0] * num2[0]) - (num1[1] * num2[1]);
        int y = (num1[0] * num2[1]) + (num1[1] * num2[0]);

        if(y == 0) {
            return Integer.toString(x);
        } else if(x == 0) {
            return Integer.toString(y) + "i";
        } else {
            return Integer.toString(x) + " + " + Integer.toString(y) + "i";
        }
    }
}
