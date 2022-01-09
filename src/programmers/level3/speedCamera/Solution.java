package programmers.level3.speedCamera;

import java.util.*;

public class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int min = Integer.MIN_VALUE;
        Arrays.sort(routes, (temp1, temp2) -> Integer.compare(temp1[1], temp2[1])); // sort -> end point

        for(int[] route : routes) {
            if(min < route[0]) {
                min = route[1];
                answer++;
            }
        }

        return answer;
    }
}
