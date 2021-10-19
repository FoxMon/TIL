package baek.reverseString;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String origin = scanner.nextLine();
        String string = "";
        Stack<Character> stack = new Stack<>();
        boolean check = true; // true -> out

        for(int i = 0; i < origin.length(); i++) { // abc <open> bcd
            if(origin.charAt(i) == '<') {
                check = false; // false -> in
                while(!stack.isEmpty()) {
                    string += stack.pop();
                }
                string += "<";
            } else if(origin.charAt(i) == '>') {
                check = true;
                string += ">";
            } else if(origin.charAt(i) == ' ') {
                while(!stack.isEmpty()) {
                    string += stack.pop();
                }
                string += " ";
            } else {
                if(check) {
                    stack.push(origin.charAt(i));
                } else {
                    string += origin.charAt(i);
                }
            }
        }

        while(!stack.isEmpty()) {
            string += stack.pop();
        }

        System.out.println(string);
    }
}
