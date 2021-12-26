package baekString.string03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        int result = str1.length();

        for(int i = 0; i <= str2.length() - str1.length(); i++) {
            int temp = 0;
            for(int j = 0; j < str1.length(); j++) {
                if(str1.charAt(j) != str2.charAt(i + j)) {
                    temp++;
                }
            }
            result = Math.min(result, temp);
        }

        System.out.println(result);
    }
}
