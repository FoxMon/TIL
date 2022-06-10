package backData.data06;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) { // H -> 1, C -> 12, O -> 16
        Scanner scanner = new Scanner(System.in);
        String chemical = scanner.next();
        Stack<Integer> stack = new Stack<>();
        HashMap<Character, Integer> value = new HashMap<>();
        value.put('H', 1);
        value.put('C', 12);
        value.put('O', 16);
        int result = 0;

        for(char ch : chemical.toCharArray()) {
            if(ch == 'H' || ch == 'C' || ch == 'O') {
                stack.push(value.get(ch));
            } else if(ch - '0' >= 0 && ch - '0' <= 9) {
                int number = stack.pop() * (ch - '0');
                stack.push(number);
            } else if(ch == ')') {
                int number = 0;
                while(stack.peek() != -1) {
                    number += stack.pop();
                }
                stack.pop();
                stack.push(number);
            } else {
                stack.push(-1);
            }
        }

        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}
