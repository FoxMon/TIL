package baek.minmax;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int min, max;
        min = max = numbers[0];

        for(int i = 1; i < numbers.length; i++) {
            if(max < numbers[i]) {
                max = numbers[i];
            }

            if(min >= numbers[i]) {
                min = numbers[i];
            }
        }

        System.out.println(min + " " + max);
    }
}
