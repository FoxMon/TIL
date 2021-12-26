package baekString.string01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        for(int i = 0; i < str.length(); i++) {
            if(i != 0 && i % 10 == 0) {
                System.out.println();
            }
            System.out.print(str.charAt(i) + "");
        }
    }
}
