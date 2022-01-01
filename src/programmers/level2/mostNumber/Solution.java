package programmers.level2.mostNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] temp = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            temp[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String temp1, String temp2) {
                return (temp2 + temp1).compareTo(temp1 + temp2);
            }
        });

        if(temp[0].equals("0")) {
            return "0";
        }

        for(String str : temp) {
            answer += str;
        }

        return answer;
    }
}
