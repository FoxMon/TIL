package practice3.findMin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int min;
        int[] numbers = new int[count];

        for(int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        min = numbers[0];

        for(int i = 1; i < numbers.length; i++) {
            if(min > numbers[i]) {
                min = numbers[i];
            }
        }

        System.out.println(min);
    }
}
