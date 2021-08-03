package practice.watermelon;

public class Solution {
    public String solution(int n) {
        String answer = "";
        String[] waterMelon = {"수", "박"};

        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                answer += waterMelon[0];
            } else {
                answer += waterMelon[1];
            }
        }

        return answer;
    }
}
