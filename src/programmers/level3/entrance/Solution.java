package programmers.level3.entrance;

import java.util.Arrays;

public class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long first = 0;
        long end = (long)n * times[times.length - 1];
        Arrays.sort(times);

        while(first <= end) {
            long mid = (first + end) / 2;
            long sum = 0;

            for(int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }

            if(sum < n) {
                first = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
