package practice2.skill022;

import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++) {
            int index = citations.length - i;

            if(index <= citations[i]) {
                answer = index;
                return index;
            }
        }

        return answer;
    }
}
