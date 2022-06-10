package programmers.level3.lineMethod;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long factorial = 1;
        ArrayList<Integer> numbers = new ArrayList<>();
        k--;

        for(int i = 1; i <= n; i++) {
            factorial *= i;
            numbers.add(i);
        }

        int index = 0;
        while(n > 0) {
            factorial /= n;
            answer[index] = numbers.get((int)(k / factorial));
            index++;
            numbers.remove((int)(k / factorial));
            k %= factorial;
            n--;
        }

        return answer;
    }
}