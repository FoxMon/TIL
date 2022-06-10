package leetCode.decodeString;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Integer> number = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        String result = "";
        int index = 0;

        while(index < s.length()) {
            if(Character.isDigit(s.charAt(index))) {
                String numberString = "";
                while(Character.isDigit(s.charAt(index))) {
                    numberString += s.charAt(index);
                    index++;
                }
                number.push(Integer.parseInt(numberString));
            } else if(s.charAt(index) == '[') {
                resultStack.push(result);
                result = "";
                index++;
            } else if(s.charAt(index) == ']') {
                result = change(number.pop(), resultStack.pop(), result);
                index++;
            } else {
                result += s.charAt(index);
                index++;
            }
        }
        return result;
    }

    private String change(int target, String result, String temp) {
        for(int i = 0; i < target; i++) {
            result += temp;
        }
        return result;
    }
}
