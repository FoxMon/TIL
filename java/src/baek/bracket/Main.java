package baek.bracket;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for(int i = 0; i < count; i++) {
            String bracket = scanner.next();

            if(isVPS(bracket)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isVPS(String bracket) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < bracket.length(); i++) {
            char current = bracket.charAt(i);

            switch (current) {
                case '(':
                    stack.push(current);
                    break;

                case ')':
                    if(stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                    break;
            }
        }

        if(stack.isEmpty()) {
           return true;
        } else {
            return false;
        }
    }
}
