package baek.teaching;

import java.util.Scanner;

public class Main {
    public static int max = Integer.MIN_VALUE;
    public static int n;
    public static int k;
    public static boolean[] alpha = new boolean[26];
    public static String[] learn;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        learn = new String[n];

        if(k < 5) {
            System.out.println(0);
            System.exit(0);
        } else if(k == 26) {
            System.out.println(n);
            System.exit(0);
        }

        for(int i = 0; i < n; i++) {
            String temp = scanner.next();
            temp = temp.substring(4, temp.length() - 4);
            learn[i] = temp;
        }

        k -= 5;
        alpha['a' - 97] = true;
        alpha['n' - 97] = true;
        alpha['t' - 97] = true;
        alpha['i' - 97] = true;
        alpha['c' - 97] = true;

        find(0, 0);
        System.out.println(max);
    }

    public static void find(int start, int level) {
        if(level == k) {
            int result = 0;

            for(int i = 0; i < n; i++) {
                boolean check = true;

                for(int j = 0; j < learn[i].length(); j++) {
                    if(!alpha[learn[i].charAt(j) - 97]) {
                        check = false;
                        break;
                    }
                }

                if(check) {
                    result++;
                }
            }
            max = Math.max(max, result);
            return;
        }

        for(int i = start; i < 26; i++) {
            if(!alpha[i]) {
                alpha[i] = true;
                find(i, level + 1);
                alpha[i] = false;
            }
        }
    }
}
