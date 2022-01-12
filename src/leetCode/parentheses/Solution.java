package leetCode.parentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if(ch == ')' || ch == ']' || ch == '}') {
                if(stack.isEmpty()) {
                    return false;
                }

                if(ch == ')') {
                    if(stack.peek() == '(') {
                        stack.pop();
                    }
                } else if(ch == ']') {
                    if(stack.peek() == '[') {
                        stack.pop();
                    }
                } else {
                    if(stack.peek() == '{') {
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
