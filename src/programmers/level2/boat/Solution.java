package programmers.level2.boat;

import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int index = 0;
        Arrays.sort(people);

        for(int i = people.length - 1; i >= index; i--) {
            if(people[index] + people[i] <= limit) {
                answer++;
                index++;
            } else {
                answer++;
            }
        }

        return answer;
    }
}
