package lv01.twonumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[] solution(int[] numbers) {

        List<Integer> array = new ArrayList<>();
        int length = numbers.length;

        for(int i = 0; i < length; i++) {
            for(int j = i + 1; j < length; j++) {
                int sum = numbers[i] + numbers[j];

                if(!array.contains(sum)) {
                    array.add(sum);
                }
            }
        }

        int[] answer = new int[array.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = array.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
