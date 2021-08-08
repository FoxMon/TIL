package practice.boat;

import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int min_index = 0;
        Arrays.sort(people);

        for(int max_index = people.length-1; min_index <= max_index; max_index--) {
            if(people[max_index] + people[min_index] <= limit) {
                min_index++;
            }

            answer++; // 50 50 70 80
        }

        return answer;
    }
}
