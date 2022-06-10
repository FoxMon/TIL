package everyday.stringReSorting02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        String newString = "";

        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) - '0' >= 0 && number.charAt(i) - '0' <= 9) {
                continue;
            } else {
                newString += number.charAt(i) + "";
            }
        }

        System.out.println(newString);
    }
}
