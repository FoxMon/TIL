package practice.jump;

public class Solution {
    public long solution(int n) {
        long answer = 0;

        if(n == 1) {
            return 1;
        }

        int[] jump = new int[n + 1];

        jump[1] = 1;
        jump[2] = 2;

        for(int i = 3; i < jump.length; i++) {
            jump[i] = (jump[i - 2] + jump[i - 1]) % 1234567;
        }

        answer = jump[n];

        return answer;
    }
}
