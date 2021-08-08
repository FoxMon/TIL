package practice.sortmax;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] sort_numbers = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            sort_numbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(sort_numbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });

        if(sort_numbers[0].equals("0")) {
            return "0";
        }

        for(String sort_number : sort_numbers) {
            answer += sort_number;
        }

        return answer;
    }
}
