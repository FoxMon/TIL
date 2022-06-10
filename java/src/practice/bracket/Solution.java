package practice.bracket;

import java.util.Stack;

public class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> bracket = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                bracket.push('(');
            } else {
                if(bracket.isEmpty()) {
                    return false;
                } else {
                    bracket.pop();
                }
            }
        }

        if(bracket.isEmpty()) {
            answer = true;
        }

        return answer;
    }
}
