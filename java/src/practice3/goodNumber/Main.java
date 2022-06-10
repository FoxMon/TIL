package practice3.goodNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] limit = new int[2];

        for(int i = 0; i < 2; i++) {
            limit[i] = scanner.nextInt();
        }

        for(int i = limit[0]; i <= limit[1]; i++) {
            if(check(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean check(int number) {
        int sum = 0;

        for(int i = 1; i < number; i++) {
            if(number % i == 0) {
                sum += i;
            }
        }

        if(sum == number) {
            return true;
        } else {
            return false;
        }
    }
}
