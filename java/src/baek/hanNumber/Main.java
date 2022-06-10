package baek.hanNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int count = 0;

        for(int i = 1; i <= number; i++) {
            if(check(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean check(int number) {
        if(number < 100) {
            return true;
        }

        String[] strNumber = Integer.toString(number).split("");
        int[] intNumber = new int[strNumber.length];

        for(int i = 0; i < strNumber.length; i++) {
            intNumber[i] = Integer.parseInt(strNumber[i]);
        }

        int diff1 = intNumber[1] - intNumber[0];
        int diff2 = intNumber[2] - intNumber[1];

        if(diff1 == diff2) {
            return true;
        }
        return false;
    }
}
