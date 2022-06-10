package baek.balanceWorld;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String bracket = scanner.nextLine();

            if(bracket.equals(".")) {
                break;
            }

            System.out.println(checkBracket(bracket));
        }
    }

    public static String checkBracket(String string) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);

            if(character == '(' || character == '[') {
                stack.push(character);
            } else if(character == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            } else if(character == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
