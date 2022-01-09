package baekBacktracking.backtracking06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        find("", number);
    }

    private static void find(String result, int number) {
        if(number == result.length()) {
            System.out.println(result);
            System.exit(0);
        }

        for(int i = 1; i <= 3; i++) {
            if(check(result + i)) {
                find(result + i, number);
            }
        }
    }

    private static boolean check(String temp) {
        int len = temp.length() / 2;

        for(int i = 1; i <= len; i++) {
            if(temp.substring(temp.length() - i).equals(temp.substring(temp.length() - 2 * i, temp.length() - i))) {
                return false;
            }
        }

        return true;
    }
}
