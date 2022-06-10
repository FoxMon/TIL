package baek.strangeNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = new String[2];
        int[] integer_numbers = new int[2];

        for(int i = 0; i < 2; i++) {
            numbers[i] = scanner.next();
        }

        for(int i = 0; i < 2; i++) {
            int number = 0;
            String strNum = "";

            for(int j = 0; j < numbers[i].length(); j++) {
                strNum += Integer.parseInt(numbers[i].charAt(numbers[i].length() - 1 - j) + "");
            }

            integer_numbers[i] = Integer.parseInt(strNum);
        }

        if(integer_numbers[0] <= integer_numbers[1]) {
            System.out.println(integer_numbers[1]);
        } else {
            System.out.println(integer_numbers[0]);
        }
    }
}
