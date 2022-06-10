package programmers.level1.minRectangle;

public class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_height = 0;
        int max_horizon = 0;

        for(int i = 0; i < sizes.length; i++) {
            int horizon = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);
            max_height = Math.max(max_height, height);
            max_horizon = Math.max(max_horizon, horizon);
        }

        answer = max_height * max_horizon;
        return answer;
    }
}
