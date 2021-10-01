package everyday.multipleOrPlus03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        int result = 0;

        for(int i = 0; i < number.length(); i++) {
            int temp = number.charAt(i) - '0';
            if(temp <= 1 || result <= 1) {
                result += temp;
            } else {
                result *= temp;
            }
        }

        System.out.println(result);
    }
}
