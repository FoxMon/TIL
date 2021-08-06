package practice.minusplus;

public class Solution {
    public static final int MINUS_SYMBOL = -1;

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i]) {
                answer += absolutes[i];
            } else {
                absolutes[i] *= MINUS_SYMBOL;
                answer += absolutes[i];
            }
        }

        return answer;
    }
}
