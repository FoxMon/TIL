package practice2.findprime;

import java.util.Scanner;

public class Main {
    public static boolean isPrime(int number) {
        if(number == 0 || number == 1) {
            return false;
        }

        int cnt = 0;

        for(int i = 1; i <= number; i++) {
            if(number % i == 0) {
                cnt++;
            }
        }

        if(cnt == 2) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        int prime_count = 0;

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        for(int i = 0; i < numbers.length; i++) {
            if(isPrime(numbers[i])) {
                prime_count++;
            }
        }

        System.out.println(prime_count);
    }
}
