package programmers.level2.spinBracket;

import java.util.*;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int k = 0; k < s.length(); k++) {
            String str = s.substring(k) + s.substring(0, k);
            if(check(str)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for(char ch : str.toCharArray()) {
            if(ch == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            } else if(ch == ']') {
                if(!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            } else if(ch == '}') {
                if(!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            } else {
                stack.push(ch);
            }
        }

        if(stack.isEmpty() && flag) {
            return true;
        } else {
            return false;
        }
    }
}