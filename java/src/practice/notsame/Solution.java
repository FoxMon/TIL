package practice.notsame;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        int previousNumber = 10;
        List<Integer> temp = new ArrayList<>();

        for(int num : arr) {
            if(previousNumber != num) {
                temp.add(num);
            }

            previousNumber = num;
        }

        answer = new int[temp.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }
}
