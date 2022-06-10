package practice.numberexpress;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int result;

        for(int i = n; i >= 1; i--) {
            result = 0;
            for(int j = i; j >= 1; j--) {
                result += j;
                if(result == n) {
                    answer++;
                } else if(result > n) {
                    break;
                }
            }
        }

        return answer;
    }
}
