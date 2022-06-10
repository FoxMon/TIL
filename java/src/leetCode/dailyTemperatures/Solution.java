package leetCode.dailyTemperatures;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] results = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                hashMap.put(stack.peek(), i - stack.pop());
            }
            stack.push(i);
        }

        for(int i = 0; i < temperatures.length; i++) {
            results[i] = hashMap.getOrDefault(i, 0);
        }

        return results;
    }
}
