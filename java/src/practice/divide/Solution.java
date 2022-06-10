package practice.divide;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int cnt = 0;
        ArrayList<Integer> divide = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                divide.add(arr[i]);
                cnt++;
            }
        }

        if(cnt == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        answer = new int[divide.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = divide.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
