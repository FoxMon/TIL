package baek.duck;

import java.util.Scanner;

public class Main {
    public static String duck;
    public static String quack = "quack";
    public static boolean[] check;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        duck = scanner.next();
        check = new boolean[duck.length()];

        if(duck.length() % 5 != 0) {
            System.out.println(-1);
            System.exit(0);
        }

        for(int i = 0; i < duck.length(); i++) {
            if(duck.charAt(i) == 'q' && !check[i]) {
                isDuck(i);
            }
        }

        for(int i = 0; i < duck.length(); i++) {
            if(!check[i]) {
                System.out.println(-1);
                System.exit(0);
            }
        }

        if(count == 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    public static void isDuck(int index) {
        int idx = 0;
        boolean first = true;

        for(int i = index; i < duck.length(); i++) {
            if(duck.charAt(i) == quack.charAt(idx) && !check[i]) {
                check[i] = true;
                if(duck.charAt(i) == 'k') {
                    if(first) {
                        count++;
                        first = false;
                    }
                    idx = 0;
                    continue;
                }
                idx++;
            }
        }
    }
}
