package practice2.carpet;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow;

        for(int i = 1; i <= area; i++) {
            int height = i;
            int width = area / height;

            if(height > width) {
                continue;
            }

            if((height - 2) * (width - 2) == yellow) {
                answer[0] = width;
                answer[1] = height;
                return answer;
            }
        }

        return answer;
    }
}
