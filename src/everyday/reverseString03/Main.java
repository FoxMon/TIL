package everyday.reverseString03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String binary = scanner.next();
        int zero = 0;
        int one = 0;

        if(binary.charAt(0) == '0') {
            zero++;
        } else {
            one++;
        }

        for(int i = 1; i < binary.length(); i++) {
            if(binary.charAt(i) != binary.charAt(i-1)) {
                if(binary.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
        }

        System.out.println(Math.min(zero, one));
    }
}
