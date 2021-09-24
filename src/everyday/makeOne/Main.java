package everyday.makeOne;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int remainder = scanner.nextInt();
        int count = 0;

        while(true) {
            if(number == 1) {
                break;
            }

            if(number % remainder == 0) {
                while(number != 1) {
                    number /= remainder;
                    count++;
                }
            } else {
                number = number - 1;
                count++;
            }
        }

        System.out.println(count);
    }
}
