package everyday.multipleOrPlus02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        long result = 0;

        for(int i = 0; i < number.length(); i++) {
            long temp = Long.parseLong(number.charAt(i) + "");
            if(result <= 1 || temp <= 1) {
                result += temp;
            } else {
                result *= temp;
            }
        }

        System.out.println(result);
    }
}
