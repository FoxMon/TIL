package baek.bracketValue02;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bracket = scanner.next();
        int answer = calculateBracket(bracket);
        System.out.println(answer);
    }

    private static int calculateBracket(String bracket) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int multiple = 1;

        for(int i = 0; i < bracket.length(); i++) {
            char current = bracket.charAt(i);

            switch (current) {
                case '(':
                    stack.push(current);
                    multiple *= 2;
                    break;

                case '[':
                    stack.push(current);
                    multiple *= 3;
                    break;

                case ')':
                    if(checkBracket(stack, current)) {
                        return 0;
                    }

                    if(bracket.charAt(i - 1) == '(') {
                        result += multiple;
                    }

                    multiple /= 2; // [()]
                    stack.pop();
                    break;

                case ']':
                    if(checkBracket(stack, current)) {
                        return 0;
                    }

                    if(bracket.charAt(i - 1) == '[') {
                        result += multiple;
                    }

                    multiple /= 2;
                    stack.pop();
                    break;
            }
        }

        if(!stack.isEmpty()) {
            return 0;
        }
        return result;
    }

    private static boolean checkBracket(Stack<Character> stack, char current) {
        if(stack.isEmpty()) {
            return true;
        }

        if(current == ']' && stack.peek() != '[') {
            return true;
        }

        if(current == ')' && stack.peek() != '(') {
            return true;
        }

        return false;
    }
}
