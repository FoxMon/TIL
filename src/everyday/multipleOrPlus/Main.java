package everyday.multipleOrPlus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        long result = 0;

        for(int i = 0; i < number.length(); i++) {
            long num = Long.parseLong(number.charAt(i) + "");
            if(num <= 1 || result <= 1) {
                result += num;
            } else {
                result *= num;
            }
        }

        System.out.println(result);
    }
}
