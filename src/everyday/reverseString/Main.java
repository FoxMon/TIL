package everyday.reverseString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int zeroCount = 0;
        int oneCount = 0;

        if(str.charAt(0) == '0') {
            zeroCount++;
        } else {
            oneCount++;
        }

        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(i - 1)) {
                if(str.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
        }

        System.out.println(Math.min(oneCount, zeroCount));
    }
}
