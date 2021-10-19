package baek.bracketValue;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bracket = scanner.next();
        int answer = calculate(bracket);
        System.out.println(answer);
    }

    public static int calculate(String bracket) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int multiple = 1;

        for(int i = 0; i < bracket.length(); i++) {
            char current = bracket.charAt(i);

            switch(current) {
                case '[':
                    stack.push(current);
                    multiple *= 3;
                    break;

                case '(':
                    stack.push(current);
                    multiple *= 2;
                    break;

                case ']':
                    if(!check(stack, current)) {
                        return 0;
                    }

                    if(bracket.charAt(i - 1) == '[') {
                        result += multiple;
                    }

                    stack.pop();
                    multiple /= 3;
                    break;

                case ')':
                    if(!check(stack, current)) {
                        return 0;
                    }

                    if(bracket.charAt(i - 1) == '(') {
                        result += multiple;
                    }

                    stack.pop();
                    multiple /= 2;
                    break;
            }
        }

        if(!stack.isEmpty()) {
            return 0;
        }

        return result;
    }

    public static boolean check(Stack<Character> stack, char current) {
        if(stack.isEmpty()) {
            return false;
        }

        if(current == ')' && stack.peek() != '(') {
            return false;
        }

        if(current == ']' && stack.peek() != '[') {
            return false;
        }

        return true;
    }
}
