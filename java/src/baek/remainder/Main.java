package baek.remainder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        int[] remainders = new int[42];

        for(int i = 0; i < remainders.length; i++) {
            remainders[i] = 0;
        }

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        for(int i = 0; i < numbers.length; i++) {
            remainders[numbers[i] % 42]++;
        }

        int count = 0;

        for(int remainder : remainders) {
            if(remainder != 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
