package everyday.temperature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> findDay(int[] temperatures) { // 65 55 70 60 55 67 64 80
        ArrayList<Integer> results = new ArrayList<>();
        Stack<Integer> stack = new Stack<>(); // 1 2 3 4
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < temperatures.length; i++) { // 슬라이딩 윈도우 two pointer
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                hashMap.put(stack.peek(), i - stack.pop());
            }
            stack.push(i);
        }

        for(int i = 0; i < temperatures.length; i++) {
            results.add(hashMap.getOrDefault(i, 0));
        }

        return results;
    }

    public static void main(String[] args) {
        int[] day = { 65, 55, 70, 60, 55, 67, 64, 80 };
        ArrayList<Integer> result = new Solution().findDay(day);
        for(int temp : result) {
            System.out.print(temp + " ");
        }
    }
}
