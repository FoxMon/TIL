package baekString.string04re;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String origin = scanner.next();
        String bomb = scanner.next();
        Stack<Character> stack = new Stack<>();

        for(char ch : origin.toCharArray()) {
            stack.push(ch);

            if(stack.size() >= bomb.length()) {
                boolean flag = true;

                for(int i = 0; i < bomb.length(); i++) {
                    char bombChar = bomb.charAt(i);
                    char originChar = stack.get(stack.size() - bomb.length() + i); // get -> good idea

                    if(bombChar != originChar) {
                        flag = false;
                        break;
                    }
                }

                for(int i = 0; i < bomb.length() && flag; i++) {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder stringBuilder = new StringBuilder();

            for(char ch : stack) {
                stringBuilder.append(ch);
            }

            System.out.println(stringBuilder.toString());
        }
    }
}
