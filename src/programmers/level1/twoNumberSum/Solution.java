package programmers.level1.twoNumberSum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> result =  new ArrayList<>();

        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                int temp = numbers[i] + numbers[j];
                if(!result.contains(temp)) {
                    result.add(temp);
                }
            }
        }
        int[] answer = new int[result.size()];
        int index = 0;
        for(int number : result) {
            answer[index++] = number;
        }

        Arrays.sort(answer);
        return answer;
    }
}
