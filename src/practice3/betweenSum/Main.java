package practice3.betweenSum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int sum = 0;

        first--;
        second--;

        for(int i = first; i <= second; i++) {
            sum += numbers[i];
        }

        System.out.println(sum);
    }
}
