package everyday.luckyStraight02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        int left = 0;
        int right = 0;

        for(int i = 0; i < number.length() / 2; i++) {
            left += number.charAt(i) - '0';
            right += number.charAt(number.length() - 1 - i) - '0';
        }

        if(left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
