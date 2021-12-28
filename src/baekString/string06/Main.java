package baekString.string06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String temp = scanner.next();
        char[] str = temp.toCharArray();
        int result = 0;

        for(char ch : str) {
            result += ch - '0';
        }

        System.out.println(result);
    }
}
