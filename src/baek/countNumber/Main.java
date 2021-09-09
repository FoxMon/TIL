package baek.countNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        int result;
        String[] str_numbers = new String[3];
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = 0;
        }

        for(int i = 0; i < str_numbers.length; i++) {
            str_numbers[i] = scanner.next();
        }

        result = Integer.parseInt(str_numbers[0]);

        for(int i = 1; i < str_numbers.length; i++) {
            result *= Integer.parseInt(str_numbers[i]);
        }

        String temp = Integer.toString(result);

        for(int i = 0; i < temp.length(); i++) {
            int count = temp.charAt(i) - '0';
            numbers[count]++;
        }

        for(int count : numbers) {
            System.out.println(count);
        }
    }
}
