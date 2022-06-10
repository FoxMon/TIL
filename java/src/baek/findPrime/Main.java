package baek.findPrime;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] range = new int[2];

        for(int i = 0; i < range.length; i++) {
            range[i] = scanner.nextInt();
        }

        for(int i = range[0]; i <= range[1]; i++) {
            if(isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int number) {
        if(number < 2) {
            return false;
        }

        for(int i = 2; i*i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
